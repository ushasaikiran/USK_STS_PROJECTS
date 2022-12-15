package com.hcl.springmvc.crud.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFactory {

	private static Connection conn;

	private DBFactory() {

	}

	public static Connection getDBConnection() {

		if (conn == null) {

			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				
				// 2. Get Connection

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db", "root", "18b81a04b5");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

		}

			return conn;
		
	}

}