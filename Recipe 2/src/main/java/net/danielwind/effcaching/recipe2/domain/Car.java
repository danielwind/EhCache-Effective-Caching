package net.danielwind.effcaching.recipe2.domain;

import java.io.Serializable;

public final class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String make;
	private String model;
	private String color;
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		sb.append("Make: " + this.make);
		sb.append(", ");
		sb.append("Model: " + this.model);
		sb.append(", ");
		sb.append("Color: " + this.color);
		sb.append("]");
		
		return sb.toString();
	}
}
