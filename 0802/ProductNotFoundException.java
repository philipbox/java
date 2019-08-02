package com.ssafy.java;


public class ProductNotFoundException extends Exception{
	
	public ProductNotFoundException() {
		System.out.println("ProductNotFoundException!");
	}
	
	public void print() {
		System.out.println("상품이 존재하지 않습니다.");
	}
}
