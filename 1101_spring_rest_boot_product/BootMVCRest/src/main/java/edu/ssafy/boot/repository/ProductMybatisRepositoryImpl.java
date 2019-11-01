package edu.ssafy.boot.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.ProductDTO;

@Repository("ProductMybatisRepositoryImpl")
public class ProductMybatisRepositoryImpl implements ProductRepository{

	@Autowired
	SqlSession session;
	
	@Override
	public int insert(ProductDTO p) {
		return session.insert("ssafy.product.insert", p);
	}

	@Override
	public int update(ProductDTO p) {
		return session.update("ssafy.product.update", p);
	}

	@Override
	public int delete(String pnum) {
		return session.delete("ssafy.product.delete", pnum);
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
