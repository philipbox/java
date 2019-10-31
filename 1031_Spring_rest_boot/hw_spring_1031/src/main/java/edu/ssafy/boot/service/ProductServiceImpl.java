package edu.ssafy.boot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.dto.ProductDTO;
import edu.ssafy.boot.repository.ProductRepository;


@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("ProductMybatisRepositoryImpl")
	ProductRepository pRepo;
	
	@Override
	public int insert(String id, String name, String price, String info) {
		return pRepo.insert(new ProductDTO(id, name, price, info));
	}//end insert

	@Override
	public int update(String id, String name, String price, String info) {
		return pRepo.update(new ProductDTO(id, name, price, info));
	}//end update

	@Override
	public int delete(String id) {
		return pRepo.delete(id);
	}//end delete

	@Override
	public ProductDTO selectOne(String id) {
		return pRepo.selectOne(id);
	}//end selectOne

	@Override
	public List<ProductDTO> selectList() {
		return pRepo.selectList();
	}// selectList
}
