package ru.kpfu.AminovNiaz.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbWrapper {
	private final String DRIVER = "org.postgresql.Driver";
	private final String URI = "jdbc:postgresql://127.0.0.1:5432/qwerty";
	private final String USER = "postgres";
	private final String PASSWORD = "futureiscoming";
	
	private Connection connection = null;
	
	
	public  Connection getConnection() {
	    if(connection == null){
	    	connection = createConnection();
	    }
	    return connection;
	  }
	
	private Connection createConnection() {
		Connection conn = null;
		
		try{
	        Class.forName(DRIVER);
	        conn = DriverManager.getConnection(URI, USER, PASSWORD);
	      }
	      catch(ClassNotFoundException e){
	        System.out.println(e.getMessage());
	      } catch (SQLException e) {
	    	  System.out.println(e.getMessage());
	    	  System.out.println(e.getSQLState());
	      }
		
		return conn;
	}
}
