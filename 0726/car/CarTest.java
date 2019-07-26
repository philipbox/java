package edu.ssafy.car;

import java.util.Scanner;

public class CarTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		CarMgr cm = CarMgr.getInstance();
		CarMgr cm2 = CarMgr.getInstance();
		
		//버스 입력
		cm.add(new Bus("111", "Benz", 70000000, 30));
		cm.add(new Bus("222", "Audi", 8000000, 40));
		cm.add(new Bus("333", "Honda", 90000000, 30));
		cm.add(new Bus("444", "Volvo", 60000000, 40));
		
		//트럭 입력
		cm2.add(new Truck("9999", "Benz", 99900000, 30));
		cm2.add(new Truck("8888", "Volvo", 77700000, 30));
		cm2.add(new Truck("7777", "Hyundai", 88800000, 30));
		cm2.add(new Truck("6666", "SAMSUNG", 990000000, 80));


		//모든 차량정보 리턴
		Car[] temp = new Car[cm.size()];
		temp = cm.search();
		System.out.println("\n==========모든 차량정보==========");
		for(int i=0; i<cm.size();i++) {
			System.out.println(temp[i].toString());
		}
		
		
		//차량번호로 차량 검색 
		System.out.println("\n==========차량번호로 차량 검색==========");
		System.out.println(cm.search("9999"));
		System.out.println(cm2.search("111"));

		
		//전달된 가격보다 작은 차량 정보 출력
		
		temp = cm.search(99000000);
		System.out.println("\n==========입력된 가격보다 작은 차량 출력==========");
		for(int i=0; i<cm.size(); i++) {
			if(temp[i]==null)
				break;
			else
				System.out.println(temp[i].toString());
		}
		
		//파라미터로 전달된 번호의 차량을 검색하여 가격을 수정
		System.out.println("\n==========입력된 차량번호의 가격 수정==========");
		System.out.println(cm.search("111"));
		cm.update("111", 700);
		System.out.println(cm.search("111"));
		
		
		//파라미터로 전달된 번호의 차량을 삭제
		System.out.println("\n==========입력된 차량번호의 차량 삭제==========");
		System.out.println(cm.search("111"));
		cm.delete("111");
		System.out.println(cm.search("111"));
		
		//배열에 저장된 차량 대수 리턴
		System.out.println("\n==========전체 차량 대수 출력==========");
		System.out.println(cm.size()+"대");
		
		
		
		//배열에 저장된 차량의 금액 합계 계산하여 리턴
		System.out.println("\n==========전체 차량 금액 합계 출력==========");
		System.out.println(cm.totalPrice()+"원");
	}//end main
}
