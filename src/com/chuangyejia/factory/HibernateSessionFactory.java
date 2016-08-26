package com.chuangyejia.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateSessionFactory {
	
	private static SessionFactory sf = null;
	
	static {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	/**
	 * 创建SessionFactory
	 * @return
	 */
	public static SessionFactory createSessionFactory() {
		if(sf != null)
			return sf;
		else
			return new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	public static void closeSessionFactory() {
		
		sf.close();
		sf = null;
	}
}
