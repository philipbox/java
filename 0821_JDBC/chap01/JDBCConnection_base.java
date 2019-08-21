package edu.ssafy.jdbc.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection_base {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
			try {
				//	1. Driver loading
				Class.forName("com.mysql.cj.jdbc.Driver");
				//	2. Connection 연결
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8",
						"ssafy", "ssafy");
				
				
				
				
				
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				//	6. 닫기
				try {
					if(rs != null) rs.close();
					if(st != null) st.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}//end finally
	}//end main
}
