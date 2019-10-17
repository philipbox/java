package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

@Component(value="pservice")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo dao;
	
	public ProductServiceImpl() {}
	public ProductServiceImpl(ProductRepo dao) {
		this.dao = dao;
	}

	@Override
	public ProductRepo getRepo() {
		return dao;
	}

	@Override
	public List<Product> selectAll() {
		List<Product> list = dao.selectAll();
		return list;
	}

	@Override
	public Product select(String id) {
		Product product = dao.select(id);
		return product;
	}

	@Override
	public int insert(Product product) {
		int res = dao.insert(product);
		return res;
	}

	@Override
	public int update(Product product) {
		int res = dao.update(product);
		return res;
	}

	@Override
	public int delete(String id) {
		int res = dao.delete(id);
		return res;
	}

}
