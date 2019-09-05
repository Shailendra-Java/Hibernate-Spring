package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectClient {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		System.out.println("For first query");
		Query q = s.createQuery("select ename from Employee01");
		q.setCacheable(true);
		List<String> list = q.list();
		for(String name:list)
		{
			System.out.println(name);
		}
		
		System.out.println("For Second query");
		Query q1 = s.createQuery("select ename from Employee01");
		q1.setCacheable(true);
		List<String> list1 = q1.list();
		for(String name:list1)
		{
			System.out.println(name);
		}
		
		System.out.println("For Third query");
		Query q2 = s.createQuery("select ename from Employee01");
		q2.setCacheable(true);
		List<String> list2 = q2.list();
		for(String name:list2)
		{
			System.out.println(name);
		}
		
		sf.close();
	}
}
