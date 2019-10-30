package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import edu.ssafy.dto.MemDTO;

@Repository("MemberRepositoryImpl")
public class MemberRepositoryImpl implements MemberRepository {

	private List<MemDTO> list = new ArrayList<MemDTO>();

	public int insert(MemDTO m) {
		if(list.add(m)) {
			return 1;
		}
		return 0;
	}//end insert

	public int update(MemDTO m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m.getNum())) {
				list.set(i, m);
				return i;
			}
		}
		return -1;
	}//end update

	public int delete(String m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m)) {
				list.remove(i);
				return i;
			}
		}
		return -1;
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
