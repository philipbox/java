package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.ProductDTO;


public interface ProductService {
	public void insert(String pnum, String pname, String price);
	public void update(String pnum, String pname, String price);
	public void delete(String pnum);
	public ProductDTO selectOne(String num);
	public List<ProductDTO> selectList();
}
