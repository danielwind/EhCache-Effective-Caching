package net.danielwind.effcaching.recipe6.utils;

import java.io.File;

public final class XMLUtil {
	
	private static final String EMPLOYEES_XML_PATH = "src/main/resources/employees.xml";
	
	public static File loadXML() {
		return new File(EMPLOYEES_XML_PATH);
	}
}
