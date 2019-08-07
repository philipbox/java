package com.ssafy.java;

public class TV extends Product{

	protected int inch;

	public TV() {
		super();
	}

	public TV(int serial, String name, int price, int stock, int inch) {
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "TV [상품번호=" + serial + ", 상품명=" + name + ", 가격=" + price + "원, 재고=" + stock + "개, 크기=" + inch + " inch]";
	}
	
	
	
	
	
}
