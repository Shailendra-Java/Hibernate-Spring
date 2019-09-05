package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class SelectUsingProjection {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		Projection p = Projections.property("name");
		c.setProjection(p);
		
		List<String> list = c.list();
		
		for(String str:list){
		System.out.println("==== User Details ====");
		System.out.println("Employee Name: "+str);
		
		}
	}
}
