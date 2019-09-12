package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class SelectUsingProjection2 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		
		Projection p1 = Projections.property("name");
		Projection p2 = Projections.property("email");
		ProjectionList plist = Projections.projectionList();
		plist.add(p1);
		plist.add(p2);
		c.setProjection(plist);
		
		List<Object[]> list = c.list();
		
		for(Object[] obj:list){
		System.out.println(obj[0]);
		System.out.println(obj[1]);
		
		}
	}
}
