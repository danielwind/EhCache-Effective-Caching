package net.danielwind.effcaching.recipe12.cache;

import net.danielwind.effcaching.recipe12.domain.Message;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.constructs.blocking.BlockingCache;

import org.apache.log4j.Logger;

public final class CacheDelegate {

	private static final Logger log = Logger.getLogger(CacheDelegate.class);
	private static final String EHCACHE_CONFIG_FILE = "ehcache.xml";
	private static final String CACHE_NAME = "applicationCache";
	
	private CacheManager manager;
	private BlockingCache blockingCache;
	private Ehcache cache;
	
	public CacheDelegate() {
		
		manager = new CacheManager(this.getClass().getClassLoader().getResourceAsStream(EHCACHE_CONFIG_FILE));
		cache = manager.getEhcache(CACHE_NAME);
		
		blockingCache = new BlockingCache(cache);
		
		//replace default cache with decorated cache (Blocking Cache)
		manager.replaceCacheWithDecoratedCache(cache, blockingCache);
	}
	
	/**
	 * Saves a message in cache layer. Currently just one value.
	 * @param message a Message object
	 */
	public void saveMessageInCache(Message message) {
		
		log.debug("--- Adding element to cache layer ---");
		blockingCache.put(new Element(message.getId(), message));
	}
	
	/**
	 * Reads a message from cache layer
	 * @param id - The ID of the message to be retrieved
	 * @return a Message instance
	 */
	public Message readMessage(String id) {
		
		Message message = null; 
		
		try {
			
			message = (Message) blockingCache.get(id).getObjectValue();
			
		} catch(NullPointerException e) {
			
			log.error("Message is not in cache anymore");
		}
				
		
		return message;
	}
	
	/**
	 * Removes all messages from cache.
	 */
	public void clearCache() {
		
		blockingCache.removeAll();
	}
	
}
