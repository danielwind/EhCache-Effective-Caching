package net.danielwind.effcaching.recipe8.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.danielwind.effcaching.recipe8.cache.CacheDelegate;
import net.danielwind.effcaching.recipe8.domain.Item;
import net.danielwind.effcaching.recipe8.domain.ItemList;
import net.danielwind.effcaching.recipe8.domain.Menu;
import net.danielwind.effcaching.recipe8.utils.XMLUtil;

import org.apache.log4j.Logger;

public class Main {

	private final static Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws JAXBException {
		
		log.info("---- Initializing Main Program -----");
		log.info("---- EhCache Server Out-Of-Process Caching Sample ----");		
		CacheDelegate cache = new CacheDelegate();
		
		//create menu
		Menu menu = new Menu();
		
		//load menu items xml and unmarshal it using JAXB
		File file = XMLUtil.loadXML();
		JAXBContext context = JAXBContext.newInstance(ItemList.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		ItemList itemList = (ItemList) unmarshaller.unmarshal(file);
		List<Item> list = itemList.getItemList();  
		Iterator<Item> itemItr = list.iterator();

	}

}
