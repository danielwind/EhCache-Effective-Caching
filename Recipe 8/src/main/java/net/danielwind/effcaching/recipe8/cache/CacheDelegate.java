package net.danielwind.effcaching.recipe8.cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

import net.danielwind.effcaching.recipe8.domain.Item;
import net.danielwind.effcaching.recipe8.exceptions.CacheServerException;
import net.sf.ehcache.Element;

import org.apache.commons.lang.SerializationUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public final class CacheDelegate {

	private static final Logger log = Logger.getLogger(CacheDelegate.class);
	
	private static final String CACHE_SERVER_URL = "http://localhost:8080/ehcache/rest/";
	
	private DefaultHttpClient client;
	
	public CacheDelegate() {
		log.info("---- Intializing Cache Delegate... ----");
	}
	
	public void saveItemInCache(String cacheName, String key, Serializable item) {
		
		//sample URL: http://localhost:8080/ehcache/rest/remoteCache/{id}
		String url = CACHE_SERVER_URL + cacheName + "/" + key;
		
		//initialize Apache HTTP Client
		client = new DefaultHttpClient(); 
		
		//create Cache Element to be sent
		Element element = new Element(key, item);
		
		//serialize object to be sent to EhCache Server
		byte[] itemToByteArray = SerializationUtils.serialize(element);  
		
		//create PUT request
		HttpPut putRequest = new HttpPut(url);
		
		//set header to read java-serialized-object
		putRequest.setHeader("Content-Type", "application/x-java-serialized-object");
		
		//set the serialized entity
		putRequest.setEntity(new ByteArrayEntity(itemToByteArray));
		
		//send the full request to EhCache Server
		try {
			
			HttpResponse response = client.execute(putRequest);
			
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED){
				
				log.info("**********************************************************************************");
				log.info("--- Item with Key [" + key + "] has been saved successfully in EhCache Server. ---");
				log.info("**********************************************************************************");    
				
			} else {
				
				String code = String.valueOf(response.getStatusLine().getStatusCode());
				throw new CacheServerException(code); 
			}
		
		} catch (ClientProtocolException e) {
			
			log.error("ClientProtocolException triggered: " + e.getMessage());
			log.error("Estimated cause: " + e.getCause());
			e.printStackTrace();
		
		} catch (IOException e) {
			
			log.error("IOException triggered: " + e.getMessage());
			log.error("Estimated cause: " + e.getCause());
			e.printStackTrace();
		}
		
		//shut down connection
		client.getConnectionManager().shutdown();
	}
	
	/**
	 * This method retrieves the cache configuration details
	 * 
	 * @param cacheName
	 * 			The name of the cache configuration living
	 * 			in the remote ehcache.xml (Server).
	 */
	public void getCacheConfiguration(String cacheName) {
		
		//sample URL: http://localhost:8080/ehcache/rest/remoteCache
		String url = CACHE_SERVER_URL + cacheName;
		
		//initialize Apache HTTP Client
		client = new DefaultHttpClient(); 
		
		HttpGet getRequest = new HttpGet(url);
		getRequest.setHeader("Content-Type","application/xml");
		
		try {
			
			HttpResponse response = client.execute(getRequest);
			
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				
				//get input stream from response
				InputStream content = response.getEntity().getContent(); 
				InputStreamReader is = new InputStreamReader(content);
				StringBuilder sb = new StringBuilder();
				BufferedReader br = new BufferedReader(is);
				String read = br.readLine();
				
				while(read != null) {
				    sb.append(read);
				    read = br.readLine();
				}
				
				//close content
				content.close();
				
			} else {
				
				String code = String.valueOf(response.getStatusLine().getStatusCode());
				throw new CacheServerException(code);
			}
		
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		//shut down connection
		client.getConnectionManager().shutdown();
	}
	
	public Item retrieveItemByKey(String cacheName, String key) {
		
		//initialize Apache HTTP Client
		client = new DefaultHttpClient();
		
		//sample URL: http://localhost:8080/ehcache/rest/remoteCache/{key}
		String url = CACHE_SERVER_URL + cacheName + "/" + key;
		
		HttpGet getRequest = new HttpGet(url);
		getRequest.setHeader("Content-Type", "application/x-java-serialized-object");
		
		//send the full request to EhCache Server
		try {
			
			HttpResponse response = client.execute(getRequest);
			
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				
				//get input stream from response
				InputStream content = response.getEntity().getContent(); 
				
				//create buffer byte-array (default size)
				byte[] buffer = new byte[4096];
				
				//calculate number of bytes and iterate to fill buffer
				int numberOfBytes = content.read(buffer);
				
				while(numberOfBytes != -1) {
					numberOfBytes = content.read(buffer);
				} 
				
				//deserialize object sent by EhCache Server
				Element retrievedElement = (Element) SerializationUtils.deserialize(buffer);
				Item retrievedElementAsItem = (Item) retrievedElement.getValue();
				
				//close input stream
				content.close();
				
				return retrievedElementAsItem;
				
			} else {
				
				String code = String.valueOf(response.getStatusLine().getStatusCode());
				throw new CacheServerException(code);
			}
			
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		
		} catch (IOException e) {

			e.printStackTrace();
		}  
				
		//shut down connection
		client.getConnectionManager().shutdown();
		
		return null;
	}

}
