package net.danielwind.effcaching.recipe7.impl;

import java.util.List;

import net.danielwind.effcaching.recipe7.cache.CacheDelegate;
import net.danielwind.effcaching.recipe7.domain.Person;
import net.danielwind.effcaching.recipe7.utils.JsonUtil;

import org.apache.log4j.Logger;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		log.info("--- Starting Recipe 7 sample ---");
		
		//load people
		List<Person> people = JsonUtil.parseFile();
		
		//create cache delegate
		CacheDelegate cache = new CacheDelegate();
		
		//load people in cache
		cache.loadInCache(people);

		//log cache status
		log.info("////////////////////////////////////////////////");
		log.info("Cache Status before update: " + cache.getCache().getMemoryStoreEvictionPolicy().getName());
		log.info("Cache total entries before update: " + cache.getCache().getSize());
		log.info("Cache total evictions before update: " + cache.getCache().getStatistics().getEvictionCount());
		log.info("////////////////////////////////////////////////");
		
		//start eviction process (insert one more item to cause cache to evict some element)
		Person person = new Person("Donald", "Trump", "dtrump@enterprise.com", "US", "21-31432-01239");
		log.debug("*** Loading one more Person in cache: " + person.toString() + " ***");
		cache.loadSingleItemInCache(person);
		
		//finally show new status
		log.info("////////////////////////////////////////////////");
		log.info("Cache Status after update:" + cache.getCache().getMemoryStoreEvictionPolicy().getName());
		log.info("Cache total entries after update: " + cache.getCache().getSize());
		log.info("Cache total evictions after update: " + cache.getCache().getStatistics().getEvictionCount());
		log.info("////////////////////////////////////////////////");
	}

}
