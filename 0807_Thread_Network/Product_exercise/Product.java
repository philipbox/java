package com.ssafy.java;


import java.io.Serializable;

public class Product implements Serializable {

	protected int serial;
	protected String name;
	protected int price;
	protected int stock;
	
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public Product() {
	}
	
	public Product(int serial, String name, int price, int stock) {
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	
	@Override
	public String toString() {
		return "Product [serial=" + serial + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	
	
	
}
