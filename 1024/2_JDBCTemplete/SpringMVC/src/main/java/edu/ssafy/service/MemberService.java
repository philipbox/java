package edu.ssafy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.exception.MyException;

@Service
public interface MemberService {
	public void insert(String num, String pw, String name, String tel) throws MyException;
	public void update(String num, String pw, String name, String tel);
	public void delete(String num);
	public boolean login(String id, String pw);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
