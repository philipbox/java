package edu.ssafy.chap07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		//Set : 중복 허용X
//		Set s = new HashSet<>();
		
		// 문자열만 받겠다는 것.
		Set<String> s = new HashSet<>();
		s.add("Gwangju");
		s.add("Seoul");
		s.add("Daejeon");
		s.add("Gumi");
//		s.add("Hello");
//		s.add(3);
//		s.add('F');
//		s.add("Hello");
//		s.add(3);
		
		
		
		Iterator iterator = s.iterator();
		while(iterator.hasNext()) {
			//다양한 타입들이 Object로 upcasting됐으니까.
			Object obj = iterator.next();
			System.out.println(obj.toString());
		}
		
		System.out.println();
		for (String string : s) {
			System.out.println(string);
		}
		
	}//end main
}
