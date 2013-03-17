package net.danielwind.effcaching.recipe11.cache;

import java.util.List;

import net.danielwind.effcaching.recipe11.domain.Message;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

public final class CacheDelegate {

	private static final Logger log = Logger.getLogger(CacheDelegate.class);
	private static final String EHCACHE_CONFIG_FILE = "ehcache.xml";
	private static final String CACHE_NAME = "applicationCache";
	
	private CacheManager manager = new CacheManager(this.getClass().getClassLoader().getResourceAsStream(EHCACHE_CONFIG_FILE));
	private Cache cache;

	public void initialize() {
		
		log.info("--- Initializing Cache Layer ---");
		cache = manager.getCache(CACHE_NAME);
	}
	
	public CacheManager getCacheManager() {
		
		return manager;
	}
	
	/**
	 * Adds messages to cache layer
	 * @param messages
	 */
	public void addToCache(List<Message> messages) {
		
		for(Message message : messages){
			cache.put(new Element(message.getId(), message));
		}
	}

	/**
	 * Retrieves a message from cache layer
	 * @param id The message ID
	 * @return A Message instance
	 */
	public Message getMessageFromCache(String id) {
		
		return (Message) cache.get(id).getObjectValue();
	}
	
}
