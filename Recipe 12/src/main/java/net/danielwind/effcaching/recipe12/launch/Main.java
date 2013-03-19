package net.danielwind.effcaching.recipe12.launch;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.danielwind.effcaching.recipe12.cache.CacheDelegate;
import net.danielwind.effcaching.recipe12.domain.Message;
import net.danielwind.effcaching.recipe12.threads.Client;
import net.danielwind.effcaching.recipe12.threads.Daemon;

import org.apache.log4j.Logger;

public final class Main {

	private static final int THREAD_POOL_SIZE = 500;
	private static final Logger log = Logger.getLogger(Main.class);
	
	private static final CyclicBarrier gate = new CyclicBarrier(THREAD_POOL_SIZE + 1);
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		
		log.info("--- Recipe 12 started ---");
		
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		
		Message message = new Message();
		message.setId("110");
		message.setContent("This is a sample message");
		message.setMedia("Content Media");
		
		final CacheDelegate cache = new CacheDelegate();
		cache.saveMessageInCache(message);
		
		//create 500 threads
		for(int i = 0; i < THREAD_POOL_SIZE; i++){
			Client client = new Client(i, cache, gate);
			executor.execute(client);
		}
		
		gate.await();
		
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Daemon daemon = new Daemon(cache);
			}
		}, 10);
		
		//finish all threads in queue
		executor.shutdown();
		
		while(!executor.isTerminated()) {
			//do nothing
		}
		
		log.debug("--- Finished ---");
	}

}