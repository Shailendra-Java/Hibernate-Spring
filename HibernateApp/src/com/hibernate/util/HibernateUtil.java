package com.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory SESSION_FACTORY = null;
	
	static {
		try {
			SESSION_FACTORY = new Configuration().configure("com/hibernate/util/hibernate.cfg.xml")
					.buildSessionFactory();
		}catch(HibernateException th) {
			System.err.println("Error : "+th);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
