package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Merge {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resourses/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.get(Student.class, 22);
		
		Student st = new Student();
		st.setId(22);
		st.setName("Thakur");
		st.setEmail("sdhakarey@yahoo.com");
		s.merge(st);
		t.commit();
		s.close();
		sf.close();
		System.out.println("Update success");
		
		
	}
}
