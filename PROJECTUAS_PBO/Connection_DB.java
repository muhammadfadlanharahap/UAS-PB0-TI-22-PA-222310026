package com.perpus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_DB {
	 private Connection conn;

	    public Connection connect() throws SQLException {
	        String host = "localhost:3306";
	        String dbName = "perpus";
	        String dbuser = "root";
	        String dbpassword = "";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	        conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbName, dbuser, dbpassword);

	        // Check if the connection is successful
	        if (conn != null && !conn.isClosed()) {
	            System.out.println("Connected to the database");
	        } else {
	            System.out.println("Failed to connect to the database");
	        }

	        return conn;
	    }

	    public Connection close() throws SQLException {
	        if (conn != null && !conn.isClosed()) {
	            conn.close();
	            System.out.println("Connection closed");
	        }
	        return conn;
	    }

	    public static void main(String[] args) {
	        Connection_DB connection_DB = new Connection_DB();

	        try {
	            Connection connection = connection_DB.connect();

	            // If the connection is successful, perform additional tasks here

	            connection_DB.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
