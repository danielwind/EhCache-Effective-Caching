package net.danielwind.effcaching.recipe8.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.danielwind.effcaching.recipe8.cache.CacheDelegate;
import net.danielwind.effcaching.recipe8.domain.Item;
import net.danielwind.effcaching.recipe8.domain.ItemList;
import net.danielwind.effcaching.recipe8.utils.XMLUtil;

import org.apache.log4j.Logger;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	private static final String CACHE_NAME = "remoteCache";
	private static final long TIMER_DELAY = 7000;
	
	public static void main(String[] args) throws JAXBException {
		
		log.info("--- Recipe 8: EhCache Server Out-Of-Process Caching Sample ---");
		
		//create timer to allow Tomcat to start! (5 secs)
		Timer timer = new Timer();
		
		log.info("-> Waiting Tomcat initialization for 5 seconds....");
		
		//schedule the event handler
		timer.schedule(new TimerTask(){
			
			@Override
			public void run(){
				
				CacheDelegate cache = new CacheDelegate();
				
				//load menu items xml and unmarshal them using JAXB
				File file = XMLUtil.loadXML();
				JAXBContext context;
				Unmarshaller unmarshaller;
				
				try {
					context = JAXBContext.newInstance(ItemList.class);
					unmarshaller = context.createUnmarshaller();
					
					ItemList itemList = (ItemList) unmarshaller.unmarshal(file);
					List<Item> list = itemList.getItems();  
					Iterator<Item> itemItr = list.iterator();
					
					while(itemItr.hasNext()){
						Item item = (Item) itemItr.next();
						log.info("Loading item: " + item.toString());
					}
					
					/**
					 * We start by invoking the RESTful Cache Layer
					 * in order to get the cache configuration details
					 * (living in the remote ehcache.xml)
					 */
					cache.getCacheConfiguration(CACHE_NAME);
					
					/**
					 * Here we will loop on all items and save one by one
					 * in our RESTful distributed cache. Normally you would
					 * save the entire List as Java Object. This is only for
					 * academic purposes.
					 */
					for(Item _item : itemList.getItems()){
						
						log.debug("saving item in cache: " + _item.getId());
						cache.saveItemInCache(CACHE_NAME, _item.getId(), _item);
					}
					
					
					//clear old JAXB item List (No longer needed)
					itemList.clear();
					
					
					/**
					 * Now let's retrieve some items from the remote
					 * cache layer. In this case, retrieving element
					 * with key = 1, 5, 9
					 */
					for(int i = 1; i < 10; i += 4){
						Item item = cache.retrieveItemByKey(CACHE_NAME, String.valueOf(i));
						log.info("********************************************************************************************");
						log.info("--- Item retrieved from Remote Cache: " + item.toString());
						log.info("********************************************************************************************");
					}
					
				} catch (JAXBException e) {
					
					log.error("JAXBException triggered: " + e.getMessage());
					log.error("Estimated cause: " + e.getCause());
					e.printStackTrace();
				}
				
				//close application
				System.exit(0);
			}
		}, TIMER_DELAY);
		
		
	}
}
