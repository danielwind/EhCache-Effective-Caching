package net.danielwind.effcaching.recipe1.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
public final class Country implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String continent;
	private String language;
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContinent() {
		return continent;
	}
	
	@XmlElement
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public String getLanguage() {
		return language;
	}
	
	@XmlElement
	public void setLanguage(String language) {
		this.language = language;
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		sb.append("Name: " + this.name);
		sb.append(",");
		sb.append("Language: " + this.language);
		sb.append(",");
		sb.append("Continent: " + this.continent);
		sb.append("]");
		
		return sb.toString();
	}
}
