package net.danielwind.effcaching.recipe2.listeners;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

import org.apache.log4j.Logger;

public class CacheDelegateEventListener implements CacheEventListener {

	private static final Logger log = Logger.getLogger(CacheDelegateEventListener.class);
	
	/*** Uncomment this line if you are using declarative factories configuration ***/
	// public static final CacheEventListener INSTANCE = new CacheDelegateEventListener();
	
	public CacheDelegateEventListener() {
		log.info("-------------------------------------------------");
		log.info("- Cache Delegate Event Listener initializing... -");
		log.info("-------------------------------------------------");
	}

	@Override
	public Object clone() {
		throw new UnsupportedOperationException("Not supported.");
	}

	@Override
	public void notifyElementRemoved(Ehcache cache, Element element)
			throws CacheException {
		
	}

	@Override
	public void notifyElementPut(Ehcache cache, Element element)
			throws CacheException {
		log.info("------ Reacting to Event: notifyElementPut ------");
		log.info("An Element has been added to cache: " + cache.getName() + ", value:" + element.toString());
	}

	@Override
	public void notifyElementUpdated(Ehcache cache, Element element)
			throws CacheException {
		log.info("------ Reacting to Event: notifyElementUpdated ------");
		log.info("An Element has been updated in cache: " + cache.getName() + ", value:" + element.toString());
	}

	@Override
	public void notifyElementExpired(Ehcache cache, Element element) {
		log.info("------ Reacting to Event: notifyElementExpired ------");
		log.info("An Element has been expired from cache: " + cache.getName() + ", value:" + element.toString());
	}

	@Override
	public void notifyElementEvicted(Ehcache cache, Element element) {
		log.info("------ Reacting to Event: notifyElementEvicted ------");
		log.info("An Element has been deleted from cache: " + cache.getName() + ", value:" + element.toString());
	}

	@Override
	public void notifyRemoveAll(Ehcache cache) {
		log.info("------ Reacting to Event: notifyRemoveAll ------");
		log.info("All Elements have been deleted from cache: " + cache.getName());
	}

	@Override
	public void dispose() {
		
		
	}

}