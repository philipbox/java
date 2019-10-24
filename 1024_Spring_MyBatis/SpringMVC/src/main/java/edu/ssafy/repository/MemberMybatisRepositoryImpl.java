package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.util.JDBCProxy;

@Repository("MemberMybatisRepositoryImpl")
public class MemberMybatisRepositoryImpl implements MemberRepository {
	@Autowired
	SqlSession session;

	
	@Override
	public void insert(MemDTO m) throws MyException {
		session.insert("ssafy.member.insert", m);
	}

	@Override
	public void update(MemDTO m) {
		session.update("ssafy.member.update", m);
	}

	@Override
	public void delete(String m) {
		session.delete("ssafy.member.delete", m);
	}

	@Override
	public boolean login(String id, String pw) {
		Connection con = JDBCProxy.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement("select pw from members where num=?");
			pst.setString(1, id);
			rs = pst.executeQuery();
			String getpw = "";
			while(rs.next()) {
				getpw = rs.getString("pw");
			}
			if(pw.equals(getpw)) return true;
			else return false;
		} catch (SQLException e) {
			System.out.println("sql Error.....");
			e.printStackTrace();
		} finally {
			JDBCProxy.close(pst, con, rs);
		}
		return false;
	}

	@Override
	public MemDTO selectOne(String m) {
		MemDTO selectOne = session.selectOne("ssafy.member.selectOne",m);
		return selectOne;
	}

	@Override
	public List<MemDTO> selectList() {
		List<MemDTO> selectList = session.selectList("ssafy.member.selectList");
		return selectList;
	}

}
