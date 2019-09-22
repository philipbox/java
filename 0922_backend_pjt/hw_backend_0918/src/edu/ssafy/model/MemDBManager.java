package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class MemDBManager {
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

	public boolean memInsert(String id, String pw, String name, String tel, String gender) {
		boolean res = false;
			try {
				conn = ConnectionProxy.getConnection();
				String sql = "insert into webMember values(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pw);
				ps.setString(3, name);
				ps.setString(4, tel);
				ps.setString(5, gender);

				ps.executeUpdate();
				res = true;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}

		return res;
	}

	public ArrayList<MemVo> memList() {
		ArrayList<MemVo> list = new ArrayList<MemVo>();
			try {
				conn = ConnectionProxy.getConnection();
				String sql = "select * from webMember";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new MemVo(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("tel"),
							rs.getString("gender")));
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

	public MemVo memInfo(String id) {
		MemVo mem = null;
			try {
				conn = ConnectionProxy.getConnection();
				String sql = "select * from webMember where id =?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					mem = new MemVo(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("tel"),
							rs.getString("gender"));
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
		return mem;
	}

	public boolean memUpdate(String id, String pw, String name, String tel, String gender) {
		boolean res = false;

			try {
				conn = ConnectionProxy.getConnection();
				String sql = "update webMember set pw=?, name=?, tel=?, gender=? where id=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, pw);
				ps.setString(2, name);
				ps.setString(3, tel);
				ps.setString(4, gender);
				ps.setString(5, id);

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

	public boolean memDelete(String id) {
		boolean res = false;

			try {
				conn = ConnectionProxy.getConnection();
				String sql = "delete from webMember where id=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				
				ps.executeUpdate();
				res = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return res;	
	}

	public boolean isLogin(String id, String pwd) {
			boolean res = false;

			String getpwd = "";
			try {
				conn = ConnectionProxy.getConnection();
				String sql = "select pw from webMember where id =?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					getpwd = rs.getString("pw");
				}
				
				if(pwd.equals(getpwd))
					res =true;
				
				
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
