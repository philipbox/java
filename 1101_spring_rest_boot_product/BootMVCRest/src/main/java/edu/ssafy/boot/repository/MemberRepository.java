package edu.ssafy.boot.repository;

import java.util.List;

import edu.ssafy.boot.dto.MemDTO;
import edu.ssafy.boot.exception.MyException;



public interface MemberRepository {
	public int insert(MemDTO m) throws MyException;
	public int update(MemDTO m);
	public int delete(String m);
	public boolean login(String id, String pw);
	public MemDTO selectOne(String m);
	public List<MemDTO> selectList();
}
