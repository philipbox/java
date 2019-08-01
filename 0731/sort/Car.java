package edu.ssafy.chap07.sort;

public class Car implements Comparable<Car>{
	String num;
	int price;
	
	Car(String num, int price){
		this.num = num;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Car [num=" + num + ", price=" + price + "]";
	}



	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		
		//오름차순
		return this.price - o.price;
		
		//내림차순
//		return o.price - this.price;
		
	}
}
