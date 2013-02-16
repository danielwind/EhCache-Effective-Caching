package net.danielwind.effcaching.recipe7.listeners;

import net.danielwind.effcaching.recipe7.domain.Person;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

import org.apache.log4j.Logger;

public class CacheDelegateEventListener implements CacheEventListener {

	private static final Logger log = Logger.getLogger(CacheDelegateEventListener.class);
	
	public CacheDelegateEventListener() {
		log.info("-------------------------------------------------");
		log.info("- Cache Delegate Event Listener initializing... -");
		log.info("-------------------------------------------------");
	}

	@Override
	public void notifyElementPut(Ehcache cache, Element element)
			throws CacheException {
		Person personAdded = (Person) element.getValue();
		
		log.debug("*****************************************************");
		log.debug("Event Notification: :: Element Put ::");
		log.debug("Element Put on Cache: " + personAdded.toString());
		log.debug("*****************************************************");
	}
	
	@Override
	public void notifyElementEvicted(Ehcache cache, Element element) {
		
		Person personEvicted = (Person)element.getValue();
		
		log.debug("***********************************************************");
		log.debug("Event Notification: :: Element Evicted ::");
		log.debug("Element Evicted from Cache: " + personEvicted.toString());
		log.debug("***********************************************************");
	}
	
	@Override
	public void notifyElementRemoved(Ehcache cache, Element element)
			throws CacheException {
		// TODO
		
	}

	@Override
	public void notifyElementUpdated(Ehcache cache, Element element)
			throws CacheException {
		// TODO
		
	}

	@Override
	public void notifyElementExpired(Ehcache cache, Element element) {
		// TODO
		
	}

	@Override
	public void notifyRemoveAll(Ehcache cache) {
		// TODO
		
	}
	
	@Override
	public void dispose() {
		// TODO
	}
	
	@Override
	public Object clone() {
		throw new UnsupportedOperationException("Not supported.");
	}
}