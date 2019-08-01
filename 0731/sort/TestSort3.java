package edu.ssafy.chap07.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestSort3 {
	public static void main(String[] args) {
		
		ArrayList<Car> list = new ArrayList<>();
		
		list.add(new Car("222",2000));
		list.add(new Car("920", 12000));
		list.add(new Car("111",3000));
		list.add(new Car("623", 8000));
		list.add(new Car("333",4000));
		
		Collections.sort(list);
		
		for(Car c : list) {
			System.out.println(c.toString());
		}
		
	}
}
