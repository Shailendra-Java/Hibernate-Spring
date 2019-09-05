package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class HQL_Update_Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//String hql = "update Student set name='ABC', email='abc@yahoo.com' where id =111";
		//String hql = "update Student set id=222 where id =111";
		String hql = "update Student set email='abc@yahoo.com' where id =222";
		Query query = session.createQuery(hql);
		int i = query.executeUpdate();
		
		transaction.commit();
		System.out.println(i+" Rows updated");
		session.close();
		sf.close();
	}
}
