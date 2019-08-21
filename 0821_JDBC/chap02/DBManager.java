package edu.ssafy.jdbc.chap02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBManager {
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	
	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public void insertStudent(int hakbun, String name, String gender, String birthday)  {
		try {
			conn = getConnection();
			
			String sql = "insert into student(hakbun, name, gender, birthday) values(?,?,?,?)";
			//prepare여기 타입 안써줬는데, 안써주는게 맞는거같은데 
			st = conn.prepareStatement(sql);
			st.setInt(1, hakbun);
			st.setString(2, name);
			st.setString(3, gender);
			st.setString(4, birthday);
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}	
	
	
	public ArrayList<Student> queryStudent(){
		ArrayList<Student> list = null;
		try {
			conn = getConnection();
			
			String sql = "select hakbun, name, gender, birthday from student";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Student s = new Student();
				s.setHakbun(rs.getInt("hakbun"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getString("gender"));
				s.setBirthday(rs.getString("birthday"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
	public void close() {
		//		6. 닫기
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
