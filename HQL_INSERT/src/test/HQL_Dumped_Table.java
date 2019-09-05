package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Old_Student;

public class HQL_Dumped_Table {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
				
		String hql="insert into New_Student(id,name,email,address) select s.id,s.name,s.email,s.address"
				+ " from Old_Student s";
		Query q = session.createQuery(hql);
		int i = q.executeUpdate();
		System.out.println("No of rows dumped from old to new student: "+i);
		
		session.close();
		sf.close();
		
	}
}
