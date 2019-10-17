package com.ssafy.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.model.dto.Product;

@Component(value="prepo")
public class ProductRepoImpl implements ProductRepo{
	private List<Product> list = new ArrayList<Product>();
	
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
	}//end close method
	
	
	
	@Override
	public List<Product> selectAll() {
		List<Product> slist = new ArrayList<Product>();
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				slist.add(new Product(rs.getString("id")
								, rs.getString("name")
								, rs.getString("price")
								, rs.getString("company")
								, rs.getString("descrip") ));
			}
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			close();
		}
	return slist;
	}//end selectAll method

	@Override
	public Product select(String id) {
		Product product = null;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "select * from product where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				product = new Product(rs.getString("id")
						, rs.getString("name")
						, rs.getString("price")
						, rs.getString("company")
						, rs.getString("descrip"));
			}
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			close();
		}
		return product;
	}//end select method

	@Override
	public int insert(Product product) {
		int res = -1;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "insert into product values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getId());
			ps.setString(2, product.getName());
			ps.setString(3, product.getPrice());
			ps.setString(4, product.getCompany());
			ps.setString(5, product.getDescription());
			res = ps.executeUpdate();
			return res;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			return res;
//			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	@Override
	public int update(Product product) {
		int res=-1;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "update product set name=?, price=?, company=?, descrip=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getPrice());
			ps.setString(3, product.getCompany());
			ps.setString(4, product.getDescription());
			ps.setString(5, product.getId());
			res = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}//end update method

	@Override
	public int delete(String id) {
		int res = -1;
		try {
			conn = ConnectionProxy.getConnection();
			String sql = "delete from product where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			res = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}//end delete method

}
