package net.danielwind.effcaching.recipe2.cache;

import java.util.List;

import net.danielwind.effcaching.recipe2.domain.Car;
import net.danielwind.effcaching.recipe2.exceptions.CacheDelegateExceptionHandler;
import net.danielwind.effcaching.recipe2.listeners.CacheDelegateEventListener;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.exceptionhandler.ExceptionHandlingDynamicCacheProxy;

import org.apache.log4j.Logger;

public final class CacheDelegate {

	private static final Logger log = Logger.getLogger(CacheDelegate.class);
	private static final String EHCACHE_CONFIG = "src/main/resources/ehcache.xml";
	private static final String CACHE_NAME = "objectCache";
	
	private CacheManager manager;
	private Ehcache cache;
	
	/**
	 * Default Constructor
	 */
	public CacheDelegate() {
		log.info("--- Initializing Cache Delegate Class... ---");
		
		manager = new CacheManager(EHCACHE_CONFIG);
		cache = manager.getCache(CACHE_NAME);
		
		//register our custom event listener
		cache.getCacheEventNotificationService().registerListener(new CacheDelegateEventListener());
		
		//set our custom exception handler
		cache.setCacheExceptionHandler(new CacheDelegateExceptionHandler());
		Ehcache proxiedCache = ExceptionHandlingDynamicCacheProxy.createProxy(cache);
		
		//replace default with decorated cache
		manager.replaceCacheWithDecoratedCache(cache, proxiedCache);
	}
	
	/**
	 * Method that loads initially the Cache layer.
	 * @param list A car list retrieved from external file
	 */
	public void initializeLoadCache(List<Car> list) {
		
		for(int i = 0; i < list.size(); i++) {
			cache.put(new Element((i + 1), list.get(i)));
		}
	}
	
	/**
	 * Method that removes a certain object (by key) from cache.
	 * Please note that this method will not log until the object
	 * gets evicted from data store.
	 * @param key The cache object key
	 */
	public void removeElementFromCache(Object key) {
		if(!cache.remove(key)){
			throw new RuntimeException("Could Not remove key-value from Cache");
		}
	}
	
	/**
	 * Method that adds a new Car object in Cache
	 * @param car Domain object instance
	 */
	public void addElementToCache(Car car) {
		cache.put(new Element((cache.getSize() + 1), car));
	}
	
	/**
	 * Updates an element in the Cache Layer (by key). 
	 * @param key The cache object key
	 * @param property the Property we want to edit
	 * @param value The desired value of the property
	 */
	public void updateElementInCache(Object key, String property, String value) {
		
		Car car = (Car) cache.get(key).getValue();
		
		switch(property){
			
			case "make":
				car.setMake(value);
			break;
			
			case "model":
				car.setModel(value);
			break;
			
			case "color":
				car.setColor(value);
			break;
		}
		
		cache.put(new Element(key, car));
	}
	
	/**
	 * Method that removes all Elements in Cache
	 */
	public void removeAllElementsInCache() {
		cache.removeAll();
	}
	
	/**
	 * Simulates an exception during a cache method
	 * execution. Invalid key.
	 */
	public void generateException() {
		cache.getCacheExceptionHandler().onException(cache, 100, new CacheException());
	}
}
