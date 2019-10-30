package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import edu.ssafy.dto.ProductDTO;

@Repository("ProductRepositoryImpl")
public class ProductRepositoryImpl implements ProductRepository {

	private List<ProductDTO> plist = new ArrayList<ProductDTO>();

	@Override
	public int insert(ProductDTO p) {
		if(plist.add(p)) {
			return 1;
		}
		return 0;
	}// end insert

	@Override
	public int update(ProductDTO p) {
		for (int i = 0; i < plist.size(); i++) {
			if(plist.get(i).getPnum().equals(p.getPnum())) {
				plist.set(i, p);
				return i;
			}
		}
		return -1;
	}//end update

	@Override
	public int delete(String pnum) {
		for(int i=0; i<plist.size(); i++) {
			if(plist.get(i).getPnum().equals(pnum)) {
				plist.remove(i);
				return i;
			}
		}
		return -1;
	}//end delete

	@Override
	public ProductDTO selectOne(String num) {
		for(int i=0; i<plist.size(); i++) {
			if(plist.get(i).getPnum().equals(num))
				return plist.get(i);
		}
		return null;
	}//end selectOne 

	@Override
	public List<ProductDTO> selectList() {
		return plist;
	}//end selectList

}
