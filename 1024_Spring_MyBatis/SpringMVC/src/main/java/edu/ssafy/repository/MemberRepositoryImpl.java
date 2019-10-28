package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import edu.ssafy.dto.MemDTO;

@Repository("MemberRepositoryImpl")
public class MemberRepositoryImpl implements MemberRepository {

	private List<MemDTO> list = new ArrayList<MemDTO>();

	public void insert(MemDTO m) {
		list.add(m);
	}//end insert

	public void update(MemDTO m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m.getNum())) {
				list.set(i, m);
			}
		}
	}//end update

	public void delete(String m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m)) {
				list.remove(i);
			}
		}
	}//end update
	
	public MemDTO selectOne(String m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m)) {
				return list.get(i);
			}
		}
		return null;
	}//end selectOne
	
	public List<MemDTO> selectList() {
		return list;
	}//end selectList

	
	@Override
	public boolean login(String id, String pw) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNum().equals(id)&&list.get(i).getPw().equals(pw)) 
				return true;
		}
		return false;
	}

}
