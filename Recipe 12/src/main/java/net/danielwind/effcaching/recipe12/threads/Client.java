package net.danielwind.effcaching.recipe12.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import net.danielwind.effcaching.recipe12.cache.CacheDelegate;
import net.danielwind.effcaching.recipe12.domain.Message;

import org.apache.log4j.Logger;

public final class Client implements Runnable {

	private static final Logger log = Logger.getLogger(Client.class);
	
	private final int id;
	private volatile CacheDelegate cache;
	private final CyclicBarrier barrier;
	
	public Client(int id, CacheDelegate cache, CyclicBarrier barrier) {
		this.id = id;
		this.cache = cache;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		
		log.debug("--- running thread " + this.id + " ---");

		try {
			//wait sync
			barrier.await();
			
			//start reading message from cache
			readMessageFromCache();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		
		} catch (BrokenBarrierException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to read cache layer
	 */
	private void readMessageFromCache() {
		
		Message message = cache.readMessage("110");
		
		log.debug("Thread cache hit: " + message);
	}
	
	public int getId() {
		return this.id;
	}
	
	public CacheDelegate getCache() {
		return this.cache;
	}
}
