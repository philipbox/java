package edu.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.ProductDTO;

@Repository("ProductMybatisRepositoryImpl")
public class ProductMybatisRepositoryImpl implements ProductRepository{

	@Autowired
	SqlSession session;
	
	@Override
	public void insert(ProductDTO p) {
		session.insert("ssafy.product.insert", p);
	}

	@Override
	public void update(ProductDTO p) {
		session.update("ssafy.product.update", p);
	}

	@Override
	public void delete(String pnum) {
		session.delete("ssafy.product.delete", pnum);
	}

	@Override
	public ProductDTO selectOne(String num) {
		ProductDTO selectOne = session.selectOne("ssafy.product.selectOne", num);
		return selectOne;
	}

	@Override
	public List<ProductDTO> selectList() {
		List<ProductDTO> selectList = session.selectList("ssafy.product.selectList");
		return selectList;
	}

	
}
