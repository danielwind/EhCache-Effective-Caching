package net.danielwind.effcaching.chapter7.cache;

import java.util.List;

import net.danielwind.effcaching.chapter7.domain.Person;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

public final class CacheDelegate {
	
	private static final Logger log = Logger.getLogger(CacheDelegate.class);
	
	private static final String CACHE_NAME = "personCache";
	private static final String EHCACHE_CONFIG_LOCATION = "src/main/resources/ehcache.xml";
	
	private Cache cache;
	private CacheManager manager;
	
	/**
	 * Constructor -- Initialize Cache Layer (EhCache)
	 */
	public CacheDelegate() {
		log.debug("-------- Configuring EhCache Delegate Class ---------");
		manager = new CacheManager(EHCACHE_CONFIG_LOCATION);
		cache = manager.getCache(CACHE_NAME); 
	}
	
	/**
	 * Loads a Person list in Cache Layer
	 * @param persons: List of Multiple Person Objects 
	 */
	public void loadInCache(List<Person> persons) {
		
		int personListSize = persons.size();
		
		if(personListSize > 0){
			
			//proceed filling cache layer with all employees
			for(int i = 0; i < personListSize; i++){
				cache.put(new Element((i + 1), persons.get(i)));
			}
		}	
	}
	
	/**
	 * Clear cache layer (Simple removal, non-clustered)
	 */
	public void emptyCache() {
		cache.removeAll();
	}
}
