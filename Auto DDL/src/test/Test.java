package test;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Test 
{
	
public static void main(String[] args)
{
	Configuration cfg = new Configuration();
	cfg.configure("resources/hibernate.cfg.xml");	
	SessionFactory sf = cfg.buildSessionFactory();
	Session s = sf.openSession();
	Transaction tr = s.beginTransaction();
	Student st = new Student();
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter student Record");
	System.out.println("Enter student ID:");
	st.setId(sc.nextInt());
	System.out.println("Enter student Name:");
	st.setName(sc.next());
	System.out.println("Enter student Email:");
	st.setEmail(sc.next());
	
	s.save(st);
	tr.commit();
	
	sf.close();
	s.close();
	
	
}
}
