package com.akash.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtility {
	

	private  static Properties properties=null;
	private static FileInputStream file=null;
	static {
		String path="src\\com\\akash\\Properties\\database.properties";
		try {
			 file=new FileInputStream(path);
			if(file!=null) {
			 properties=new Properties();
			 properties.load(file);
			}
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
		}
	
				
		
	
		public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
		
	       return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("userName"),properties.getProperty("password"));
		    
		
	}
	
	}
