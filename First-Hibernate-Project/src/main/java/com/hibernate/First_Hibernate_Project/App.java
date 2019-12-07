package com.hibernate.First_Hibernate_Project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Person;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure("resources/hibernate.cfg.xml");
    	SessionFactory sessionFactory = cfg.buildSessionFactory();
    	Session session = sessionFactory.getCurrentSession();
    	Transaction trx = session.beginTransaction();
    	
    	try {
    		Person person = new Person(102,"Tom Moddy","tom@gmail.com","@456");
    		session.delete(person);
    		trx.commit();
    	}catch(Exception exp) {
    		System.err.println(exp);
    		trx.rollback();
    	}
    }
}
