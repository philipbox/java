package edu.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProxy {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			System.out.println("class load fail......");
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb?useSSL=false&serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");
		} catch(SQLException e) {
			
		}
		return conn;
	}
	
	public static void close(Statement st, Connection conn, ResultSet rs) {
		if(rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
		if(st != null) { try { st.close(); } catch (SQLException e) { e.printStackTrace(); } }
		if(conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	}
	
	public static void close(Statement st, Connection conn) {
		if(st != null) { try { st.close(); } catch (SQLException e) { e.printStackTrace(); } }
		if(conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	}
}
