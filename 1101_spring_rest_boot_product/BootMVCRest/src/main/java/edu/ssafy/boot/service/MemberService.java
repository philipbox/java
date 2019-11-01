package edu.ssafy.boot.service;

import java.util.List;


import org.springframework.stereotype.Service;

import edu.ssafy.boot.dto.MemDTO;
import edu.ssafy.boot.exception.MyException;


@Service
public interface MemberService {
	public int insert(String num, String pw, String name, String tel) throws MyException;
	public int update(String num, String pw, String name, String tel);
	public int delete(String num);
	public boolean login(String id, String pw);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
