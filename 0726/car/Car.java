package edu.ssafy.car;

public class Car {
	protected String num;
	protected String model;
	protected int price;
	
	//defualt Constructor
	public Car() {
	}
	
	public Car(String num, String model, int price) {
		this.num = num;
		this.model = model;
		this.price = price;
	}
	
	
	public void setNum(String num) {
		this.num = num;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	


	
	@Override
	public String toString() {
		return "Car [num=" + num + ", model=" + model + ", price=" + price + "]";
	}
	
	
	
}
