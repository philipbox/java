package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.ssafy.controller.DBCP;

public class ProductDAO {

	// DBCP 
	private static DataSource ds;
	
	static {
		try {
			//...env/까지는 외웡!
			ds = (DataSource) new InitialContext().lookup("java:comp/env/ssafy/mysql");
			System.out.println("lookup success!!");
		} catch (NamingException e) {
			System.out.println("lookup fail!!");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = ds.getConnection();
		if(conn != null) {
			System.out.println("연결 성공!!");
		}
		else {
			System.out.println("연결 실패!!");
		}
		return conn;
	}
	// DBCP end--------------------------------
	
	// 삽입
//	public boolean InsertProduct() {
//		try {
//			Connection conn = DBCP.getConnection();
//			PreparedStatement pst = conn.prepareStatement("select empno, ename, sal from emp where empno = ?");
//			pst.setString(1,  "7369");
//			ResultSet rs = pst.executeQuery();
//			while(rs.next()) {
//				String empno = rs.getString("empno");
//				String ename = rs.getString("ename");
//				String sal = rs.getString("sal");
//				
//				System.out.println(empno + "," + ename +"," + sal);
//				
//				
//				
//				return true;
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		return false;
//	}
	
	// 수정 
	public void UpdateProduct() {
		
	}
	
	// 삭제
	public void DeleteProduct() {
		
	}
	
	// 출력
	public ArrayList<Product> ListProduct() {
		ArrayList<Product> pList = new ArrayList<Product>();
		try {
			Connection conn = DBCP.getConnection();
			PreparedStatement pst = conn.prepareStatement("select id, name, price from productlist");
//			pst.setString(1,  "7369");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				

				System.out.println(id + "," + name +"," + id);
				pList.add(new Product(id,name,price));
			}
			return pList;
		}
		catch (Exception e) {
			System.out.println("ListProduct method .. Catch");
			e.printStackTrace();
		}
		return pList;
	}
	
	
	
	// 검색
	public void SearchProduct() {
		
		
		
	}
	
	
}
