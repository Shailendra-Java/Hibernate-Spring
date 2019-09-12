package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String[] args) {
	try{
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session1 = sf.openSession();
		System.out.println("Using first session");
		Student st1 = (Student)session1.get(Student.class, 2);
		
			System.out.println(st1.getName());
			System.out.println(st1.getEmail());
		
		Student st2 = (Student)session1.get(Student.class, 2);
		
			System.out.println(st2.getName());
			System.out.println(st2.getEmail());
			
		System.out.println("Using second session");
		Session session2 = sf.openSession();
		Student st3 = (Student)session2.get(Student.class, 2);
			
			System.out.println(st3.getName());
			System.out.println(st3.getEmail());
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
