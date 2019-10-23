package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.repository.MemberRepository;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {

	@Autowired
	@Qualifier("MemberRepositoryImpl")
	MemberRepository repo;

	@Override
	public void insert(String num, String pw, String name, String tel) {
		repo.insert(new MemDTO(num,pw,name,tel));
	}

	@Override
	public void update(String num, String pw, String name, String tel) {
		repo.update(new MemDTO(num,pw, name,tel));
	}

	@Override
	public void delete(String num) {
		repo.delete(num);
	}

	@Override
	public MemDTO selectOne(String num) {
		return repo.selectOne(num);
	}

	@Override
	public List<MemDTO> selectList() {
		return repo.selectList();
	}
}
