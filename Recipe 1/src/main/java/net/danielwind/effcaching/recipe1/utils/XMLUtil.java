package net.danielwind.effcaching.recipe1.utils;

import java.io.File;

public final class XMLUtil {
	
	private static final String COUNTRIES_XML_PATH = "src/main/resources/countries.xml";
	
	public static File loadXML() {
		return new File(COUNTRIES_XML_PATH);
	}
}
