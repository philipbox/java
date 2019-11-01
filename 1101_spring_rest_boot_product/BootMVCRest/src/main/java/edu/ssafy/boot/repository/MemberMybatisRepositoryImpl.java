package edu.ssafy.boot.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.MemDTO;
import edu.ssafy.boot.exception.MyException;

@Repository("MemberMybatisRepositoryImpl")
public class MemberMybatisRepositoryImpl implements MemberRepository {
	@Autowired
	SqlSession session;

	
	@Override
	public int insert(MemDTO m) throws MyException {
		return session.insert("ssafy.member.insert", m);
	}

	@Override
	public int update(MemDTO m) {
		return session.update("ssafy.member.update", m);
	}

	@Override
	public int delete(String m) {
		return session.delete("ssafy.member.delete", m);
	}

	@Override
	public boolean login(String id, String pw) {
		String getpw = session.selectOne("ssafy.member.login", id);
		if(getpw.equals(pw)) return true;
		else return false;
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
