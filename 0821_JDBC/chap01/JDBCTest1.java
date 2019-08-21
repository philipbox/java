package edu.ssafy.jdbc.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// 예외처리 안하고 그냥 던진 경우.
public class JDBCTest1 {
	public static void main(String[] args) throws Exception {
		
		
		//	1. Driver loading
		//강제적으로 클래스를 포출함!
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//	2. Connection 연결
		//getConnection이라는 static method 호출 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8",
				"ssafy", "ssafy");
		
		//	3. Query 작성
		Statement st = conn.createStatement();
		String sql = "select * from emp";
		//execute는 return이 boolean으로 확인.
//		boolean execute = st.execute(sql);
		
		//	4. Query 실행
		//executeQuery는 그 결과 집합이 들어감 
		ResultSet rs = st.executeQuery(sql);
		
		//	5. 결과 추출 
		// next는 이터레이터 패턴. 데이터가 있는지 없는지 T/F로 준다. 성공하면 false를 준다.
		// 데이터가 있으면 T를 주겠지. 
		while(rs.next()) {
			// 여기서 변수에 저장되던걸 변수용 클래스를 만들어서 넣으면 좋겠지.
//			//row단위로 움직인다.
//			String ename = rs.getString("ename");
//			int sal = rs.getInt("sal");
//			System.out.println(ename + ","+sal);
					
			EMPVO emp = new EMPVO();
			emp.setEname(rs.getString("ename"));
			emp.setSal(rs.getInt("sal"));
			System.out.println(emp.toString());
		}
		
		//	6. 닫기
		rs.close();
		st.close();
		conn.close();
		
	}
}
