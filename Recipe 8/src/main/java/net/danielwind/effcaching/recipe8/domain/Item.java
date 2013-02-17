package net.danielwind.effcaching.recipe8.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public final class Item implements Serializable {

	/**
	 * Very important since we are serializing objects,
	 * and sending them over the wire. Performance can  
	 * be greatly improved. 
	 */
	private static final long serialVersionUID = 8233529004641536075L;
	
	private String id;
	private String category;
	private String description;
	private String image;
	private Double price;
	
	public Item() {
		
	}
	
	public String getId() {
		return id;
	}
	
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}
	
	@XmlElement
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}
	
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}
	
	@XmlElement
	public void setImage(String image) {
		this.image = image;
	}
	
	public Double getPrice() {
		return price;
	}
	
	@XmlElement
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		sb.append("ID: " + this.id);
		sb.append(", ");
		sb.append("category: " + this.category);
		sb.append(", ");
		sb.append("description: " + this.description);
		sb.append(", ");
		sb.append("image: " + this.image);
		sb.append(", ");
		sb.append("price: " + this.price);
		sb.append("]");
		
		return sb.toString();
	}
}
