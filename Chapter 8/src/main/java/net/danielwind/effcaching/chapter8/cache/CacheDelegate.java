package net.danielwind.effcaching.chapter8.cache;

import java.io.IOException;
import java.io.InputStream;

import net.danielwind.effcaching.chapter8.domain.Item;
import net.danielwind.effcaching.chapter8.exceptions.CacheServerException;

import org.apache.commons.lang.SerializationUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public final class CacheDelegate {

	private static final Logger log = Logger.getLogger(CacheDelegate.class);
	
	private static final String CACHE_SERVER_URL = "http://localhost:8080/ehcache/rest/tableColumn";
	
	private DefaultHttpClient client;
	
	public CacheDelegate() {
		//----- initialize Apache HttpClient -----//
		client = new DefaultHttpClient();
		log.info("---- Intializing Cache Delegate... ----");
	}
	
	public void saveItemInCache(Item item) throws ClientProtocolException, IOException {
		
		//serialize object to be sent to EhCache Server
		byte[] itemToByteArray = SerializationUtils.serialize(item);
		
		//create request payload to EhCache Server (PUT)
		HttpPut putRequest = new HttpPut(CACHE_SERVER_URL);
		putRequest.setHeader("Content-Type", "text/plain");
		putRequest.setEntity(new ByteArrayEntity(itemToByteArray));
		
		//send the full request to EhCache Server
		HttpResponse response = client.execute(putRequest);
		
		//analyze http response status code 
		if(response.getStatusLine().getStatusCode() != 200){
		
			String code = String.valueOf(response.getStatusLine().getStatusCode());
			throw new CacheServerException(code);
		
		} else {
			log.info("----- Item saved successfully in EhCache Server. ------");
		}
	}
	
	public Item retrieveItemByKey(String key) throws ClientProtocolException, IOException {
		
		//invoke EhCache Server (GET)
		HttpGet getRequest = new HttpGet(CACHE_SERVER_URL);
		
		//send the full request to EhCache Server
		HttpResponse response = client.execute(getRequest);
		
		if(response.getStatusLine().getStatusCode() != 200){
			
			String code = String.valueOf(response.getStatusLine().getStatusCode());
			throw new CacheServerException(code);
			
		} else {
			log.info("----- Item retrieved from EhCache Server.... ------");
			log.info("------- Starting deserializing process.. ------------");
			
			//get input stream from response
			InputStream content = response.getEntity().getContent();
			
			//create buffer byte-array (default size: )
			byte[] buffer = new byte[4096];
			
			//calculate number of bytes and iterate to fill buffer
			int numberOfBytes = content.read(buffer);
			
			while(numberOfBytes != -1) {
				numberOfBytes = content.read(buffer);
			}
			
			//deserialize object sent by EhCache Server
			Item retrievedItem = (Item) SerializationUtils.deserialize(buffer);
			
			//close input stream
			content.close();
			
			log.info("---------- Finished deserializing process.. ------------");
			
			return retrievedItem;
		}
	}

}
