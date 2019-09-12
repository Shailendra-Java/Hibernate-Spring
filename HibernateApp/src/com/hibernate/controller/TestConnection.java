package com.hibernate.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
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

@WebServlet(urlPatterns = "/connect")
public class TestConnection extends HttpServlet{

	public TestConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			List<Student> allStudents = session.createQuery("from Student").list();
			
			RequestDispatcher rd = req.getRequestDispatcher("allStudents.jsp");
			req.setAttribute("allStd", allStudents);
			rd.include(req, resp);
		}catch(Exception exception) {
			System.err.println("Problem : "+exception);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	
}
