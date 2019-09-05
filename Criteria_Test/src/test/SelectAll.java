package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class SelectAll {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		List<Employee> list = c.list();
		
		for(Employee emp:list)
		{
			System.out.println("==== User Details ====");
			System.out.println("Employee ID: "+emp.getId());
			System.out.println("Employee Name: "+emp.getName());
			System.out.println("Employee Email: "+emp.getEmail());
			System.out.println("Employee Salary: "+emp.getSalary()+"\n\n");
		}
	}
}
