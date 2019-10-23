package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.ProductDTO;

public interface ProductRepository {
	public void insert(ProductDTO p);
	public void update(ProductDTO p);
	public void delete(String pnum);
	public ProductDTO selectOne(String num);
	public List<ProductDTO> selectList();
}
