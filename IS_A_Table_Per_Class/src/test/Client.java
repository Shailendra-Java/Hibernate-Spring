package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Admin;
import beans.Hardware_Employee;
import beans.Software_Employee;

public class Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Software_Employee se = new Software_Employee(111, 15000, "Sanjay", "s@gmail.com", "Spring");
		Hardware_Employee he = new Hardware_Employee(222, 20000, "Pravin", "p@yahoo.com", 3);
		Admin ad = new Admin(333, 35000, "Sanjay", "s@live.in", "Bangalore");
		
		session.save(se);
		session.save(he);
		session.save(ad);
		t.commit();
		
		session.close();
		sf.close();
	}
}
