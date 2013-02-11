package net.danielwind.effcaching.recipe1.cache;

import java.util.List;

import net.danielwind.effcaching.recipe1.domain.Country;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import org.apache.log4j.Logger;

public final class CacheDelegate {

	private static final Logger log = Logger.getLogger(CacheDelegate.class);
	private static final String EHCACHE_CONFIG = "src/main/resources/ehcache.xml";
	private static final String CACHE_NAME = "objectCache";
	
	private CacheManager manager;
	private Ehcache cache; 
	
	/**
	 * Initializes EhCache upon instantiation
	 */
	public CacheDelegate() {
		log.info("--- Initializing EhCache configuration... ---");
		
		/**** 
		 * Uncomment this line if you wish to use programmatic approach 
		 * And comment lines 33 and 34.
		 ****/
		//configureCacheProgramatically();
		
		manager = new CacheManager(EHCACHE_CONFIG);
		cache = manager.getCache(CACHE_NAME);
	}
	
	/**
	 * Method (not being invoked) to show how to configure EhCache
	 * programmatically instead of loading ehcache.xml. 
	 */
	public void configureCacheProgramatically() {
		
		//create cache manager configuration object
		Configuration cacheManagerConfiguration = new Configuration(); 
		
		/****
		 * Create cache configuration object. Note the configuration parameters
		 * Are the same ones as in the ehcache.xml file we created.
		 ****/
		CacheConfiguration cacheConfiguration = new CacheConfiguration("objectCache", 100)
											        .eternal(true)
											        .maxEntriesLocalHeap(100)
											        .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.FIFO);
		
		//add cache object to cache manager
		cacheManagerConfiguration.addCache(cacheConfiguration);
		
		//update global class level Cache Manager
		manager = new CacheManager(cacheManagerConfiguration);
		
		//get final cache object
		cache = manager.getEhcache("objectCache");
	}
	
	/**
	 * Method for loading a List (Collection) of Country Objects
	 * @param countries List of Country Objects
	 */
	public void loadElementsInCache(List<Country> countries) {
		
		//proceed filling cache layer with all countries
		for(int i = 0; i < countries.size(); i++){
			cache.put(new Element((i + 1), countries.get(i)));
		}
	}
	
	/**
	 * Simply logs in the output console all the elements
	 * that have been stored in Cache Layer (cached).
	 */
	public void ShowAllElementsInCache() {
		
		log.info("------------------------------------");
		log.info("--- Retrieving Key Elements List ---");
		log.info("------------------------------------");
		
		for(Object element: cache.getKeys()){
			log.info("key: " + element + ", element: " + cache.get(element));
		}
	}

}
