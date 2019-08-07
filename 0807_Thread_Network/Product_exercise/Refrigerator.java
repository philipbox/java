package com.ssafy.java;


public class Refrigerator extends Product {

	protected int liter;

	public Refrigerator() {
		super();
	}
	
	public Refrigerator(int serial, String name, int price, int stock, int liter) {
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.liter = liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}

	public int getLiter() {
		return liter;
	}

	@Override
	public String toString() {
		return "냉장고 [상품번호=" + serial + ", 상품명=" + name + ", 가격=" + price+ "원, 재고=" + stock + "개, 수용량=" + liter + "L]";
	}
	
	
	
	
	
	
	
}
