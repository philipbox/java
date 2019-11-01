package edu.ssafy.boot.repository;

import java.util.List;

import edu.ssafy.boot.dto.ProductDTO;



public interface ProductRepository {
	public int insert(ProductDTO p);
	public int update(ProductDTO p);
	public int delete(String pnum);
	public ProductDTO selectOne(String num);
	public List<ProductDTO> selectList();
}
