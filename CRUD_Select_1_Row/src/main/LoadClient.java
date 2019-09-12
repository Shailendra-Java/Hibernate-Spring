package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class LoadClient {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resourses/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Object o = s.load(Student.class, 11);
		Student st = (Student)o;
		
		System.out.println("Student ID: "+st.getId());
		System.out.println("Student Name: "+st.getName());
		System.out.println("Student Email: "+st.getEmail());
		
		s.close();
		sf.close();
		
		System.out.println("Select complete");
		
	}
}
