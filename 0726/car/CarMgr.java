package edu.ssafy.car;

public class CarMgr {

	private Car[] cars = new Car[100];
	private int index=0;
	
	private static CarMgr cm = new CarMgr();
	
	public static CarMgr getInstance() {
		return cm;
	}
	
	//파라미터로 전달된 차량정보를 배열에 저장
	public void add(Car c) {
		cars[index] = c;
		index++;
	}
	
	//현재 저장된 모든 차량정보를 리턴
	public Car[] search() {
		Car[] tmp = new Car[index];
		for(int i=0; i<index; i++) {
			 tmp[i] = cars[i];
		}
		return tmp;
	}
	
	//파라미터로 전달된 번호와 같은 차량 정보 리턴
	public Car search(String num) {
		Car tmp = new Car();
		for(int i=0; i<index; i++) {
			if(num.equals(cars[i].num)) {
				tmp = cars[i];
			}
		}
		return tmp;
	}
	
	//파라미터로 전달된 가격보다 작은 차량 정보들을 리턴
	public Car[] search(int price) {
		Car[] tmp = new Car[index];
		for(int i=0; i<index; i++) {
			if(price > cars[i].price)
				tmp[i] = cars[i];
		}
		return tmp;
	}
	
	//파라미터로 전달된 번호의 차량을 검색하여 가격을 수정
	public void update(String num, int price) {
		for(int i=0; i<index; i++) {
			if(num.equals(cars[i].num))
				cars[i].price = price;	
		}
		System.out.println("차량 가격이 수정되었습니다.");
	}
	
	//파라미터로 전달된 번호의 차량을 삭제
	public void delete(String num) {
		for(int i=0; i<index; i++) {
			if(num.equals(cars[i].num))
				remove_car(i);
		}
	}
	
	//배열에 저장된 차량 대수 리턴
	public int size() {
		return index;
	}
	
	//배열에 저장된 차량의 금액 합계 계산하여 리턴
	public int totalPrice() {
		int sum=0;
		for(int i=0; i<index; i++) {
			sum += cars[i].price;
		}
		return sum;
	}

	// 지정된 차를 삭제하기 위한 메소드
	private void remove_car(int idx) {
		cars[idx]=cars[index-1];
		index--;
	}
	
	
	
}
