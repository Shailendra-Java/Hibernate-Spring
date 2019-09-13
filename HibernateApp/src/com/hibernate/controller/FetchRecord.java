package com.hibernate.controller;

import java.io.IOException;
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

import com.hibernate.model.Student;
import com.hibernate.util.HibernateUtil;

@WebServlet(urlPatterns = "/fetch")
public class FetchRecord extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			List<String> allStudents = session.createQuery("select distinct address from Student").list();
			
			
			  RequestDispatcher rd = req.getRequestDispatcher("fetchRecord.jsp");
			  req.setAttribute("stdList", allStudents); 
			  rd.include(req, resp);
			 
		}catch(Exception exception) {
			System.err.println("Problem : "+exception);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		String ctry = req.getParameter("ctry");
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query q = session.createQuery("from Student where address=:addr");
			q.setString("addr", ctry );
			List<String> allStudents = q.list();
			  RequestDispatcher rd = req.getRequestDispatcher("allStudents.jsp");
			  req.setAttribute("allStd", allStudents); 
			  rd.include(req, resp);
			 
		}catch(Exception exception) {
			System.err.println("Problem : "+exception);
		}
	}

	
}
