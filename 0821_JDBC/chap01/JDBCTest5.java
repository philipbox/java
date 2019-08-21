package edu.ssafy.jdbc.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest5 {
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
				
				
				String sql = "delete from test where id=?";
//				String sql = "update test set title=? , body=?";
//				String sql = "insert into test(title, body) values(?,?)";
				
				st = conn.prepareStatement(sql);
				
				st.setInt(1, 20);
//				st.setString(1, "change");
//				st.setString(2, "change2");
				
				int row = st.executeUpdate();
				if(row>=1) {
					System.out.println("입력성공");
				}

				String sql2 = "select * from test";
				PreparedStatement st2 = conn.prepareStatement(sql2);
				st2.executeQuery();
				ResultSet rs2 = st2.executeQuery();
				while(rs2.next()) {
					System.out.println(rs2.getInt("id")+","+rs2.getString("title")+","+rs2.getString("body"));
				}
				
//				boolean rst = st.execute();
//				ResultSet set = st.executeQuery();
				// 여러개를 한꺼번에 
//				Result[] stsd = st.executeBatch();
				// return 인트 , 몇개가 도ㅒㅆ는지 
//				int cnt = st.executeUpdate();
				
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
