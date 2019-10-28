package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.ProductDTO;
import edu.ssafy.repository.ProductRepository;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("ProductRepositoryImpl")
	ProductRepository pRepo;
	
	@Override
	public void insert(String pnum, String pname, String price) {
		pRepo.insert(new ProductDTO(pnum, pname, price));
	}//end insert

	@Override
	public void update(String pnum, String pname, String price) {
		pRepo.insert(new ProductDTO(pnum, pname, price));
	}//end update

	@Override
	public void delete(String pnum) {
		pRepo.delete(pnum);
	}//end delete

	@Override
	public ProductDTO selectOne(String num) {
		return pRepo.selectOne(num);
	}//end selectOne

	@Override
	public List<ProductDTO> selectList() {
		return pRepo.selectList();
	}// selectList
}
