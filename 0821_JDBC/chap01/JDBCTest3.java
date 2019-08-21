package edu.ssafy.jdbc.chap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//쿼리 입력받는게 조금 귀찮았어. 이걸 쉽게할 수 있는 방법!
//statement를 로딩을 받았어.
// 하나는 Test2까지 하던 방식이고 다른 하나는 preparestatement야 
public class JDBCTest3 {
	public static void main(String[] args)  {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
			try {
				//	1. Driver loading
				Class.forName("com.mysql.cj.jdbc.Driver");
				//	2. Connection 연결
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8",
						"ssafy", "ssafy");
				
				//	3. Query 작성
				System.out.println("입력하세요.");
				Scanner sc = new Scanner(System.in);
				int sal = sc.nextInt();
				int deptno = sc.nextInt();
				
				// preparestatement 사용
				String sql = "select * from emp where sal > ? and deptno= ?";
				st = conn.prepareStatement(sql);
				st.setInt(1, sal);
				st.setInt(2, deptno);
				
				//	4. Query 실행
				// 	여기서는 파라미터로 들어가던 sql을 빼줬지.
				rs = st.executeQuery();
				
				//	5. 결과 추출 
				while(rs.next()) {
					EMPVO emp = new EMPVO();
					emp.setEname(rs.getString("ename"));
					emp.setSal(rs.getInt("sal"));
					System.out.println(emp.toString());
				}
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
			}

			
		}
}
