package edu.ssafy.chap07.sort;

import java.util.Arrays;
import java.util.Comparator;

public class TestSort {
	public static void main(String[] args) {
		Integer[] ins = new Integer[5];
		ins[0] = 6;
		ins[1] = 21;
		ins[2] = 8;
		ins[3] = 66;
		ins[4] = 2;
		
		// 내림차순을 위한 방법
		Comparator<Integer> com = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		};
		
		Arrays.sort(ins,com);
		
		for(Integer i : ins) {
			System.out.print(i+" ");
		}
		
	}
}
