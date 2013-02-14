package net.danielwind.effcaching.recipe5.embed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hsqldb.Server;

public final class HsqlEmbeddedServer {

	private static final Logger log = Logger.getLogger(HsqlEmbeddedServer.class);
	
	private static final String DATABASE_NAME = "recipe5";
	private static final String DATABASE_PATH = "file:database.properties";
	private static final String HSQLDB_JDBC_DRIVER = "org.hsqldb.jdbcDriver";
	
	private Server hsqlServer;
	
	public HsqlEmbeddedServer() {
		
		log.info("--- Initializing HSQLDB Embedded Server ---");
		
		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
        hsqlServer.setSilent(true);
        
        hsqlServer.setDatabaseName(0, DATABASE_NAME);
        hsqlServer.setDatabasePath(0, DATABASE_PATH);
	}
	
	/**
	 * Connects to the HSQLDB Embedded Server
	 */
	public void connect() {
		
		hsqlServer.start();
		Connection connection = null;
		
		try {
			
			Class.forName(HSQLDB_JDBC_DRIVER);
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/" + DATABASE_NAME,"sa","");
			
			log.info("--- HSQLDB Started successfully ---");
			
		} catch (ClassNotFoundException e) {
			log.error("There was a problem loading the JDBC driver");
		
		} catch (SQLException e) {
			log.error("There was a problem with the SQL connection: " + e.getMessage().toLowerCase());
		
		} finally {
			
			try {
				connection.close();
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Stops the HSQLDB Embedded Server
	 */
	public void terminate() {
		hsqlServer.stop();
	}

}
