package edu.ssafy.chap07;

import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("Seoul");
		list.add("Gwangju");
		list.add("Ansan");

		list.get(0);
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
