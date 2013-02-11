package net.danielwind.effcaching.recipe2.impl;

import java.util.List;

import net.danielwind.effcaching.recipe2.cache.CacheDelegate;
import net.danielwind.effcaching.recipe2.domain.Car;
import net.danielwind.effcaching.recipe2.utils.JsonUtil;

import org.apache.log4j.Logger;

public final class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		log.info("--- Initializing Recipe #2 ---");
		
		//load car list
		List<Car> carList = new JsonUtil().parseFile();

		//create cache delegate instance
		CacheDelegate cache = new CacheDelegate();
		
		//load initial data in cache
		cache.initializeLoadCache(carList);
		
		//--------- Perform operations ---------//
		
		//add car to cache
		Car car = new Car();
		
		car.setMake("BMW");
		car.setModel("X7");
		car.setColor("Orange");
		
		cache.addElementToCache(car);
		
		//remove Mercedes-Benz (key = 5)
		cache.removeElementFromCache(5);
		
		//update car
		cache.updateElementInCache(4, "color", "Yellow");
		
		//generate exception
		cache.generateException();
		
		//remove all
		cache.removeAllElementsInCache();
	}

}
