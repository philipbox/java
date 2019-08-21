package edu.ssafy.jdbc.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 던지지않고 예외처리를 해보자.
public class JDBCTest2 {
public static void main(String[] args)  {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
		try {
			//	1. Driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			//	2. Connection 연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");
//			3. Query 작성
			st = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			int sal = sc.nextInt();
			int deptno = sc.nextInt();
			
			String sql = "select * from emp where sal >"+sal+" and deptno="+deptno;
			//execute는 return이 boolean으로 확인.
//			boolean execute = st.execute(sql);
			
			//	4. Query 실행
			//executeQuery는 그 결과 집합이 들어감 
			rs = st.executeQuery(sql);
			
			//	5. 결과 추출 
			// next는 이터레이터 패턴. 데이터가 있는지 없는지 T/F로 준다.
			// 데이터가 있으면 T를 주겠지. 
			while(rs.next()) {
				// 여기서 변수에 저장되던걸 변수용 클래스를 만들어서 넣으면 좋겠지.
//				//row단위로 움직인다.
//				String ename = rs.getString("ename");
//				int sal = rs.getInt("sal");
//				System.out.println(ename + ","+sal);
						
				EMPVO emp = new EMPVO();
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getInt("sal"));
				System.out.println(emp.toString());
			}
			
			// 닫기부분은 여기 있으면 안됨. finally로 빠져야하지.
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		
		

		
	}
}
