package edu.ssafy.chap07.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestSort4 {
	public static void main(String[] args) {
		
		ArrayList<Bag> list = new ArrayList<>();
		
		list.add(new Bag(2000));
		list.add(new Bag(12000));
		list.add(new Bag(3000));
		list.add(new Bag(8000));
		list.add(new Bag(4000));
		
		
		//Comparable을 구현하지 않아서 에러떠.
//		Collections.sort(list);
		
		
		Comparator<Bag> compar = new Comparator<Bag>() {

			@Override
			public int compare(Bag o1, Bag o2) {
				return o1.price - o2.price;
				// o2.price - o1.price
				// 이거는 내림차순
			}};
		
			Collections.sort(list, compar);
			
			for(Bag c : list) {
				System.out.println();
			}
		
	}
}
