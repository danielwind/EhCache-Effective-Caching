package net.danielwind.effcaching.recipe11.impl;

import java.util.List;
import java.util.Random;

import net.danielwind.effcaching.recipe11.cache.CacheDelegate;
import net.danielwind.effcaching.recipe11.domain.Message;
import net.danielwind.effcaching.recipe11.utils.JsonUtil;

import org.apache.log4j.Logger;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		log.info("--- Starting Recipe 11 program in VM ---");
		
		//load messages from json file
		List<Message> messages = JsonUtil.parseFile();
		
		//create cache delegate instance
		CacheDelegate cache = new CacheDelegate();
		
		//initialize cache (load Ehcache XML)
		cache.initialize();
		
		//load messages in cache layer
		cache.addToCache(messages);
		
		Random random = new Random();
		
		//start loading messages forever
		while(true) {
			
			//get a random id
			Message message = messages.get(random.nextInt(messages.size()));
			cache.getMessageFromCache(message.getId());
			
			//clean reference
			message = null;
		}
	}

}
