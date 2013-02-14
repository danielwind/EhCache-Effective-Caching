package net.danielwind.effcaching.recipe5.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

	private static final SessionFactory sessionFactory = createSessionFactory();

	/**
	 * Creates a session factory Hibernate Object
	 * @return SessionFactory static reference
	 */
	private static SessionFactory createSessionFactory() {
		
		try{
			
			return new Configuration().configure().buildSessionFactory();
		
		} catch(Throwable exception) {
			
			throw new ExceptionInInitializerError(exception);	
		}
	}
	
	/**
	 * @return SessionFactory static reference
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * Close cache and connection pool
	 */
	public static void shutdown() {
		sessionFactory.close();
	}
}
