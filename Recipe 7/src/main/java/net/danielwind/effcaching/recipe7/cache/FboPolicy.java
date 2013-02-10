package net.danielwind.effcaching.recipe7.cache;

import net.sf.ehcache.Element;
import net.sf.ehcache.store.AbstractPolicy;

public class FboPolicy extends AbstractPolicy {
	
	//Our custom cache eviction policy (FIRST BORN OUT)
	public static final String NAME = "FBO";
	
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * Read the elements cache metadata and compares both with our
	 * custom comparison algorithm. In this simple case, we are simply 
	 * using the creationTime metadata to determine element longevity.
	 */
	@Override
	public boolean compare(Element element1, Element element2) {
		
		return element2.getCreationTime() < element1.getCreationTime();
	}

}
