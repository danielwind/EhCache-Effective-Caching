package net.danielwind.effcaching.recipe5.main;

import net.danielwind.effcaching.recipe5.embed.HsqlEmbeddedServer;
import net.danielwind.effcaching.recipe5.model.MovieEntity;
import net.danielwind.effcaching.recipe5.utils.HibernateUtil;
import net.sf.ehcache.CacheManager;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public final class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		log.info("--- Starting Recipe 5 program (Hibernate Second Level Caching with EhCache) ---");
		
		//start HSQLDB Embedded Server
		HsqlEmbeddedServer database = new HsqlEmbeddedServer();
		database.connect();
		
			//Initialize Hibernate session
			int i = 0;
			
			while(i < 20) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				MovieEntity movie = (MovieEntity) session.get(MovieEntity.class, Long.valueOf(1));
				log.debug("Movie Entity found: " + movie.toString());
				session.getTransaction().commit();
				session.close();
				i++;
			}
			
			log.info("------------------------------------------------------------------------------------");
			log.info(CacheManager.getInstance().getCache("entityCache").getStatistics().toString());
			log.info("------------------------------------------------------------------------------------");
	}

}
