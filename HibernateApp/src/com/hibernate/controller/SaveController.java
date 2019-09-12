package com.hibernate.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.Student;
import com.hibernate.util.HibernateUtil;

@WebServlet(urlPatterns = "/save")
public class SaveController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = ""+new Random().nextInt(350);
		String fn = req.getParameter("fn");
		String ln = req.getParameter("ln");
		String gender = req.getParameter("gen");
		String dob =(req.getParameter("dob"));
		String addr = req.getParameter("addr");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		Student st = new Student(id, fn, ln, gender, dob, addr, phone, email, pass);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(st);
			session.getTransaction().commit();
			
			resp.getWriter().println("<html><body><h1>Registration Done</h1></body></html>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, resp);
		}catch(Exception exp) {
			System.err.println("Problem : "+exp);
		}
	}

}
