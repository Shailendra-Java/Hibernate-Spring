package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class SelectUsingRestrictions {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		// Where =
		//Criterion cr = Restrictions.eq("id", 111);
		
		//Where >
		Criterion cr = Restrictions.gt("salary", 6000);
		c.add(cr);
		
		//Employee emp = (Employee) c.uniqueResult();
		
		List<Employee> list = c.list();
		for(Employee emp:list){
		System.out.println("==== User Details ====");
		System.out.println("Employee ID: "+emp.getId());
		System.out.println("Employee Name: "+emp.getName());
		System.out.println("Employee Email: "+emp.getEmail());
		System.out.println("Employee Salary: "+emp.getSalary());
		}
	}
}
