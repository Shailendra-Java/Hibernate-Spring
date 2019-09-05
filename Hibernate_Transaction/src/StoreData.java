

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.*;

@WebServlet("/StoreData")
public class StoreData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SessionFactory sessionFactory;
	Session session = null;
	Transaction transaction = null;
    
    public StoreData() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productStock = 0;
		double productPrice = 0;
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		double price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		try
		{
			Configuration cfg = new Configuration().configure("resource/hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			int productId=111;
			int orderedItemQt = 100;
			
			ProductDetails pdetails = new ProductDetails();
			pdetails.setPid(pid);
			pdetails.setPname(pname);
			pdetails.setPrice(price);
			pdetails.setStock(stock);
			session.save(pdetails);
			System.out.println("Data stored");
			
			Query query = session.createQuery("FROM ProductDetails WHERE ProductId="+productId);
			List<ProductDetails> lst = new ArrayList<>();
			lst = query.list();
			for(Iterator it=lst.iterator();it.hasNext();)
			{
				ProductDetails product = (ProductDetails)it.next();
				productStock = product.getStock();
				productPrice = product.getPrice();
			}
			int updatedStock = productStock - orderedItemQt;
			double totalPrice = productPrice * orderedItemQt;
			
			String strQuery = "UPDATE ProductDetails SET stock = :updateStock where "
					+ "productID = :productID";
			query = session.createQuery(strQuery);
			query.setInteger("productID", productId);
			query.setDouble("updateStock", updatedStock);
			
			int updatedRow = query.executeUpdate();
			
			OrderDetails od = new OrderDetails();
			od.setPid(productId);
			od.setQuantity(orderedItemQt);
			od.setTotalprice(totalPrice);
			session.save(od);
			transaction.commit();
			out.println("Order placed");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}catch(Exception exp)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			exp.printStackTrace();
		}
		finally
		{
			if(session != null)
			{
				session.close();
			}
		}
		
	}

}
