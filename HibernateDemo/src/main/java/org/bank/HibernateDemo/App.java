package org.bank.HibernateDemo;

import org.bean.Address;
import org.bean.Customer;
import org.bean.Supplier;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("org/resources/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Customer c1 = new Customer(101, "Chirag", "Kumar", "chirag@abc.com");
		Customer c2 = new Customer(103, "Sukriti", "Singh", "suk@abc.com");
		c1.setAddress(new Address("India", "Haryana", "Faridabad"));
		c2.setAddress(new Address("India", "Uttar Pradesh", "Meruth"));

		Supplier sp1 = new Supplier("Praveen", "pd@yahoo.com");
		sp1.setAddress(new Address("India", "Uttar Pradesh", "Agra"));

		try {

			session.save(c1);
			session.save(c2);

			session.save(sp1);
			transaction.commit();
		} catch (HibernateException exp) {
			System.out.println("Problem : " + exp);
			transaction.rollback();
		} catch (Exception exp) {
			System.out.println("Problem : " + exp);
		}
	}
}
