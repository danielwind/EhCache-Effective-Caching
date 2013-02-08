package net.danielwind.effcaching.chapter8.utils;

import java.io.File;

public final class XMLUtil {
	
	private static final String ITEMS_XML_PATH = "src/main/resources/items.xml";
	
	public static File loadXML() {
		return new File(ITEMS_XML_PATH);
	}
}
