package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Old_Student;

public class ClientInsert {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Old_Student os1 = new Old_Student(111, "Abc", "abc@gmail", "Agra");
		Old_Student os2 = new Old_Student(222, "Abd", "abd@gmail", "Mathura");
		Old_Student os3 = new Old_Student(333, "Xyz", "xyz@gmail", "Gwalior");
		
		session.save(os1);
		session.save(os2);
		session.save(os3);
		
		t.commit();
		session.close();
		sf.close();
		
		System.out.println("Data inserted successfully");
	}
}
