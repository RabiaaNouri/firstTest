package com.project.db;


import java.sql.Connection;
import java.sql.DriverManager;
public class DataBaseConnection {
Connection con;
	 
	    public Connection connexionDB() {    
	    	  try
	          {
	              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	              con=DriverManager.getConnection("jdbc:sqlserver://localhost:49637;databaseName=application;user=sa;password=rabiaa");
	          }
	          catch(Exception e)
	          {
	              e.printStackTrace();
	          }

	          return con;        
	      }
	    
}