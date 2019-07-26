package edu.ssafy.car;

public class Truck extends Car {
	
	protected int ton;

	//default constructor
	public Truck() {
		super();
	}

	public Truck(String num, String model, int price, int ton) {
		super(num, model, price);
		this.ton = ton;
	}
	
	public void setTon(int ton) {
		this.ton = ton;
	}
	
	@Override
	public String toString() {
		return "트럭 [차량번호="+num+", 모델명="+model+", 가격="+price+", 톤="+ton+"]";
	}



	
	
	
}
