package edu.ssafy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProxy {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/memberweb?useSSL=false&serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");
		return conn;
	}
}
