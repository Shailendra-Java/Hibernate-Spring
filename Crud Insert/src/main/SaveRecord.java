package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

import beans.Student;

public class SaveRecord {

	public static void main(String[] args) {
		
		String name,email;
		int id;
		Scanner sc = new Scanner(System.in);
		
		Configuration cfg = new Configuration();
		cfg.configure("resourses/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Student st = new Student();
		
			System.out.println("Enter ID:");
			id = sc.nextInt();
			System.out.println("Enter Name:");
			name = sc.next();
			System.out.println("Enter Email:");
			email = sc.next();
			try{
				Transaction t = s.beginTransaction();
				st.setId(id);
				st.setName(name);
				st.setEmail(email);
				int pk = (Integer)s.save(st);
				System.out.println("Primary key: "+pk);
				t.commit();
			
			}catch(Exception e)
			{
				System.out.println("Error: "+e);
			}
	}
}
