package net.danielwind.effcaching.chapter8.domain;

import java.io.Serializable;
import java.util.List;

public final class Menu implements Serializable {
	
	/**
	 * Very important since we are serializing objects,
	 * performance can be greatly improved. 
	 */
	private static final long serialVersionUID = -5927259498362969551L;
	
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}
}
