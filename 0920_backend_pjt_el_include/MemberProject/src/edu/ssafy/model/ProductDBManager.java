package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductDBManager {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<ProductVo> productList() {
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
			try {
				conn = ConnectionProxy.getConnection();
				String sql = "select * from productList";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new ProductVo(rs.getString("id"), rs.getString("name"), rs.getInt("price"), rs.getInt("count")));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}
		return list;
	}
	
	
	public boolean productInsert(String id, String name, int price, int count) {
		boolean res = false;
			try {
				conn = ConnectionProxy.getConnection();
				String sql = "insert into productList values(?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setInt(3, price);
				ps.setInt(4, count);

				ps.executeUpdate();
				res = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
		return res;
	}
	
	
	
	
}



