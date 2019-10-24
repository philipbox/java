package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;

public interface MemberRepository {
	public void insert(MemDTO m) throws MyException;
	public void update(MemDTO m);
	public void delete(String m);
	public boolean login(String id, String pw);
	public MemDTO selectOne(String m);
	public List<MemDTO> selectList();
}
