package edu.ssafy.car;

public class Bus extends Car {

	protected int seats;

	
	//default constructor
	public Bus() {
		super();
	}

	public Bus(String num, String model, int price, int seats) {
		super(num, model, price);
		this.seats = seats;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "버스 [차량번호="+num+", 모델명="+model+", 가격="+price+", 좌석수="+seats+"]";
	}
	
	
	
	
}
