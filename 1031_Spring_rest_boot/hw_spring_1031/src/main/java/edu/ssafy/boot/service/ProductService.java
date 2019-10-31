package edu.ssafy.boot.service;

import java.util.List;

import edu.ssafy.boot.dto.ProductDTO;
public interface ProductService {
	public int insert(String id, String name, String price, String info);
	public int update(String id, String name, String price, String info);
	public int delete(String id);
	public ProductDTO selectOne(String id);
	public List<ProductDTO> selectList();
}
