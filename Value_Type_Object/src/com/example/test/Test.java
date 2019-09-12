package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.example.entity.Address;
import com.example.entity.Student;

public class Test {

	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student(); 

        student.setName("Shailendra");
        student.setDepartment("CSE");
        student.setCollege("GLA");

        Address address1 = new Address();
        address1.setStreet("Kundol");
        address1.setCity("Agra");
        address1.setState("Uttar Pradesh");
        address1.setPincode("283111");
        student.setAddress(address1);
        session.save(student);  

        tx.commit(); 
        session.close();
        sf.close();
	}

}
