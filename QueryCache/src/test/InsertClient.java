package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class InsertClient {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Employee e1 = new Employee();
		e1.setEid(123);
		e1.setEname("Shailendra");
		e1.setEmail("sthakur@gmail.com");
		e1.setSalary(25000);
		
		Employee e2 = new Employee();
		e2.setEid(456);
		e2.setEname("Sanjay");
		e2.setEmail("sanjay@gmail.com");
		e2.setSalary(85000);
		
		s.save(e1);
		s.save(e2);
		s.beginTransaction().commit();
		System.out.println("Record inserted");
	}
}
