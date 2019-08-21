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
	
	static {
		//static block에서는 throw 못해.
		try {
			//	1. Driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public DBManager() throws SQLException {
		//여기서 Exception은 던지는게 맞아. 
		//여기 안에서 처리하는게 아니라, 던져서 처리하는게 맞지.
		//	2. Connection 연결
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8",
				"ssafy", "ssafy");
	}
	
	
	
	
	
	public int insertStudent(int hakbun, String name, String gender, String birthday) throws SQLException {
		String sql = "insert into student(hakbun, name, gender, birthday) values(?,?,?,?)";
		//prepare여기 타입 안써줬는데, 안써주는게 맞는거같은데 
		st = conn.prepareStatement(sql);
		st.setInt(1, hakbun);
		st.setString(2, name);
		st.setString(3, gender);
		st.setString(4, birthday);
		
		return st.executeUpdate();
	}	
	
	public ArrayList<Student> queryStudent() throws SQLException{
		String sql = "select hakbun, name, gender, birthday from student";
		st = conn.prepareStatement(sql);
		rs = st.executeQuery();
		ArrayList<Student> list = new ArrayList<>();
		while(rs.next()) {
			Student s = new Student();
			s.setHakbun(rs.getInt("hakbun"));
			s.setName(rs.getString("name"));
			s.setGender(rs.getString("gender"));
			s.setBirthday(rs.getString("birthday"));
			list.add(s);
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
