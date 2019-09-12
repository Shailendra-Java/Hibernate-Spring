package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Test 
{
	public static void main(String[] args) {
		
		Student st = new Student();
		st.setId(111);
		st.setName("Abc");
		st.setEmail("abc@gmail.com");
		st.setMarks(88);
		// Here object is in transient state
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		s.save(st);
		// Here object in persistent state
		
		s.beginTransaction().commit();
		System.out.print("Data saved");
		// Now object in database permanent state
		
		s.evict(st);
		// Now object remove from session
		// And garbage collector will receive object 
	}
}
