package edu.ssafy.chap07.sort;

import java.util.Arrays;

public class TestSort2 {
	public static void main(String[] args) {
		
		Car[] cars = new Car[5];
		cars[0] = new Car("222",2000);
		cars[1] = new Car("920", 12000);
		cars[2] = new Car("111",3000);
		cars[3] = new Car("623", 8000);
		cars[4] = new Car("333",4000);
		
		
		//그냥 이렇게하면 정렬기준이 없어서 안돼. 
		// Comparable을 구현해야해.
		Arrays.sort(cars);
		
		for(Car c : cars) {
			System.out.println(c.toString());
		}
		
	}
}
