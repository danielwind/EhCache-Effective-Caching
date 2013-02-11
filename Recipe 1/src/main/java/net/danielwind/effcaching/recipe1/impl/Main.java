package net.danielwind.effcaching.recipe1.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.danielwind.effcaching.recipe1.cache.CacheDelegate;
import net.danielwind.effcaching.recipe1.domain.Country;
import net.danielwind.effcaching.recipe1.domain.CountryList;
import net.danielwind.effcaching.recipe1.utils.XMLUtil;

import org.apache.log4j.Logger;

public final class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws JAXBException {
		
		log.info("--- Starting Recipe 1 Program ----");
		
		//load employees.xml and unmarshal it using JAXB
		File file = XMLUtil.loadXML();
		JAXBContext context = JAXBContext.newInstance(CountryList.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		CountryList CountryList = (CountryList) unmarshaller.unmarshal(file);
		List<Country> list = CountryList.getCountries();  
		Iterator<Country> countryItr = list.iterator();
		
		while(countryItr.hasNext()){
			Country country = (Country) countryItr.next();
			log.info("loading Country: [" + country.toString() + "]");
		}
		
		//Initialize Cache Delegate
		CacheDelegate cache = new CacheDelegate();
		cache.loadElementsInCache(list);
		
		//show all elements in cache layer
		cache.ShowAllElementsInCache();
	}

}
