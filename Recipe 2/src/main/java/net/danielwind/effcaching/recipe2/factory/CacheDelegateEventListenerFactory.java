package net.danielwind.effcaching.recipe2.factory;

import java.util.Properties;

import net.danielwind.effcaching.recipe2.listeners.CacheDelegateEventListener;
import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

public class CacheDelegateEventListenerFactory extends
		CacheEventListenerFactory {

	public CacheDelegateEventListenerFactory() {}

	@Override
	public CacheEventListener createCacheEventListener(Properties properties) {
		/*** uncomment line if declarative configuration is used ***/
		//return CacheDelegateEventListener.INSTANCE;
		return null;
	}

}
