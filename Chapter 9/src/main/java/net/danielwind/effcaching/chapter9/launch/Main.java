package net.danielwind.effcaching.chapter9.launch;

import java.io.File;
import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.log4j.Logger;

public final class Main {

	private static final String WEBAPP_DIR_LOCATION = "./src/main/webapp/";
	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws ServletException, LifecycleException {
		
		//create embedded tomcat instance and initialize port
		Tomcat tomcat = new Tomcat();
		String httpServerPort = System.getenv("PORT");
		
		if(httpServerPort == null || httpServerPort.isEmpty()){
			httpServerPort = "8080";
		}
		
		tomcat.setPort(Integer.parseInt(httpServerPort));
		tomcat.addWebapp("/", new File(WEBAPP_DIR_LOCATION).getAbsolutePath());
		
		log.info("-- Configuring Application with Base Directory: " + new File(WEBAPP_DIR_LOCATION).getAbsolutePath() + " --");
		
		//start tomcat and wait for deployment
		tomcat.start();
		tomcat.getServer().await();
	}

}