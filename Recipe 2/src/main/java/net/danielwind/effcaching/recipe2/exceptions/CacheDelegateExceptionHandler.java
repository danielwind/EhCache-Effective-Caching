package net.danielwind.effcaching.recipe2.exceptions;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.exceptionhandler.CacheExceptionHandler;

import org.apache.log4j.Logger;

public class CacheDelegateExceptionHandler implements CacheExceptionHandler {

	private static final Logger log = Logger.getLogger(CacheDelegateExceptionHandler.class);
	
	/*** Uncomment this line if you are using declarative factories configuration ***/
	// public static final CacheDelegateExceptionHandler INSTANCE = new CacheDelegateExceptionHandler();
	
	public CacheDelegateExceptionHandler() {
		log.info("----------------------------------------------------");
		log.info("- Cache Delegate Exception Handler initializing... -");
		log.info("----------------------------------------------------");
	}

	@Override
	public void onException(Ehcache ehcache, Object key, Exception exception) {
		log.error("=> Exception occured in cache instance: " + ehcache.getName()); 
		log.error("=> While manipulating object: " + ehcache.get(key));
	}
}
