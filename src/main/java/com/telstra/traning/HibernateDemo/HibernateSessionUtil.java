package com.telstra.traning.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {
	
	public static Session createHibernateSession()

	{
	Session session=null;
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	session=sessionFactory.openSession();

	return session;
	}

}
