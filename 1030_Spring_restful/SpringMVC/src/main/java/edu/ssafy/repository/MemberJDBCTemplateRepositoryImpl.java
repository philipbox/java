package edu.ssafy.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.util.JDBCProxy;

@Repository("MemberJDBCTemplateRepositoryImpl")
public class MemberJDBCTemplateRepositoryImpl implements MemberRepository{

	// 여기 구현 안되어있음 
	
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int insert(MemDTO m) throws MyException {
		jt.update("insert into members(num, pw, name, tel) values(?,?,?,?)"
				, new Object[] {m.getNum(), m.getPw(), m.getName(), m.getTel()});
		return 0;
	}

	String updateSql = "update members set pw=?, name=?, tel=? where num=?";
	@Override
	public int update(MemDTO m) {
		jt.update(updateSql
				, new Object[] {m.getPw(), m.getName(), m.getTel(), m.getNum()});
		return 0;
	}

	@Override
	public int delete(String m) {
		jt.update("delete from members where num=?"
				, new Object[] {m});
		return 0;
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

	class MemberMapper implements RowMapper<MemDTO>{
		@Override
		public MemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemDTO m = new MemDTO();
			m.setNum(rs.getString("num"));
			m.setPw(rs.getString("pw"));
			m.setName(rs.getString("name"));
			m.setTel(rs.getString("tel"));
			return m;
		}
	}
	
	@Override
	public MemDTO selectOne(String m) {
		MemDTO dto = jt.queryForObject("select num, pw, name, tel from members where num=?" 
				,new Object[] {m} 
				,new MemberMapper());
		return dto;
	}

	@Override
	public List<MemDTO> selectList() {
		List<MemDTO> list = jt.query("select num, pw, name, tel from members", new MemberMapper());
		return list;
	}

}
