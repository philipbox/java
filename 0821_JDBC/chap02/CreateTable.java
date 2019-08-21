package edu.ssafy.jdbc.chap02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 조회는 했으니까, 테이블 만드는거 해보자.
public class CreateTable {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
			try {
				//	1. Driver loading
				Class.forName("com.mysql.cj.jdbc.Driver");
				//	2. Connection 연결
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8",
						"ssafy", "ssafy");
				
				
				// 동적이 아니니까 prepare안해도됨 
				st = conn.createStatement();
//				String sql = "create table student(hakbun int primary key auto_increment"
//						+ ", name varchar(100) not null"
//						+ ", gender varchar(3) check(gender in('남','여'))"
//						+ ", birthday datetime";
				String sql = "create table student(hakbun int primary key auto_increment, name varchar(100) not null , gender varchar(3) check(gender in('남','여')), birthday datetime)";
				
				if(!st.execute(sql))
					System.out.println("table 만들기 성공");
				else
					System.out.println("어림없지");
				
				
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
