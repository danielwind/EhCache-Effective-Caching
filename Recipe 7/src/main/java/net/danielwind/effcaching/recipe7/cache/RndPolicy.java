package net.danielwind.effcaching.recipe7.cache;

import org.apache.log4j.Logger;

import net.danielwind.effcaching.recipe7.utils.RNG;
import net.sf.ehcache.Element;
import net.sf.ehcache.store.AbstractPolicy;

public class RndPolicy extends AbstractPolicy {
	
	//Our custom cache eviction policy (Random Replacement Cache) 
	public static final String NAME = "RND";
	private static final Logger log = Logger.getLogger(RndPolicy.class);
	
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * Read the elements cache metadata and compares both with our
	 * custom comparison algorithm. In this simple case, we are simply 
	 * using the creationTime metadata to determine element longevity.
	 * 
	 * Comparing in Ehcache works as described below:
	 * if returns true => second element is preferable for eviction
	 * if returns false => first element is preferable for eviction
	 */
	@Override
	public boolean compare(Element element1, Element element2) {
		
		/**
		 * 50% chances of getting a false comparing 
		 */
		if(RNG.getValue() > 5){
			log.debug("--- Calculated random value generated in RND Policy: "+ false);
			return false;
		
		} else {
			log.debug("--- Calculating random value generated in RND Policy: "+ true);
			return true;
		}
	}

}
