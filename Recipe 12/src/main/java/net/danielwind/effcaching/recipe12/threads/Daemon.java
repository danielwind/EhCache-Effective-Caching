package net.danielwind.effcaching.recipe12.threads;

import org.apache.log4j.Logger;

import net.danielwind.effcaching.recipe12.cache.CacheDelegate;

public final class Daemon implements Runnable {

	private static final Logger log = Logger.getLogger(Daemon.class);
	
	private volatile CacheDelegate cache;
	
	public Daemon(CacheDelegate cache) {
		this.cache = cache;
	}

	@Override
	public void run() {
		
		log.debug("--- invoking cache clearing ---");
		cache.clearCache();
	}

}
