package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import edu.ssafy.dto.ProductDTO;

@Repository("ProductRepositoryImpl")
public class ProductRepositoryImpl implements ProductRepository {

	private List<ProductDTO> plist = new ArrayList<ProductDTO>();

	@Override
	public void insert(ProductDTO p) {
		plist.add(p);
	}// end insert

	@Override
	public void update(ProductDTO p) {
		for (int i = 0; i < plist.size(); i++) {
			if(plist.get(i).getPnum().equals(p.getPnum())) {
				plist.set(i, p);
			}
		}
	}//end update

	@Override
	public void delete(String pnum) {
		for(int i=0; i<plist.size(); i++) {
			if(plist.get(i).getPnum().equals(pnum)) {
				plist.remove(i);
			}
		}
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
