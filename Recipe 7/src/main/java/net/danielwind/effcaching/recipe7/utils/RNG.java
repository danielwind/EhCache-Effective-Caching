package net.danielwind.effcaching.recipe7.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.log4j.Logger;

public final class RNG {
	
	private static final Logger log = Logger.getLogger(RNG.class);
	
	public static int getValue() {
		
		//more powerful random
		Random random = new SecureRandom();
		int next = random.nextInt(10);
		log.debug("Value generated: " + next);
		return next;
	}

}
