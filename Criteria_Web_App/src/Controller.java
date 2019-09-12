

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("eid"));
		String name = request.getParameter("eName");
		String email = request.getParameter("eEmail");
		double salary = Double.parseDouble(request.getParameter("eSalary"));
		
		// code to store record
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Employee emp = new Employee(id, name, email, salary);
		try
		{
			session.persist(emp);
			tr.commit();
			String msg = "Success! :- Record inserted";
			response.sendRedirect("index.jsp?msg="+msg);
		}catch(Exception exp)
		{
			String msg = "Failed! :- "+exp;
			response.sendRedirect("index.jsp?msg="+msg);
		}
		finally
		{
			session.close();
			sf.close();
		}
	}

}
