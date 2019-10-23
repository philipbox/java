package edu.ssafy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ssafy.dto.MemDTO;

@Service
public interface MemberService {
	public void insert(String num, String pw, String name, String tel);
	public void update(String num, String pw, String name, String tel);
	public void delete(String num);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
