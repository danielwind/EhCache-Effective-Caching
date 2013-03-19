package net.danielwind.effcaching.recipe12.domain;

import java.io.Serializable;

/**
 * Serializable Thread-Safe Domain Object
 * @author danielwind
 *
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String content;
	private String media;
	
	public synchronized String getId() {
		return id;
	}
	
	public synchronized void setId(String id) {
		this.id = id;
	}
	
	public synchronized String getContent() {
		return content;
	}
	
	public synchronized void setContent(String content) {
		this.content = content;
	}
	
	public synchronized String getMedia() {
		return media;
	}
	
	public synchronized void setMedia(String media) {
		this.media = media;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Message: [");
		sb.append("ID: " + this.id);
		sb.append(",");
		sb.append(" Media: " + this.media);
		sb.append(",");
		sb.append(" Content: " + this.content);
		sb.append("]");
		
		return sb.toString();
	}
}