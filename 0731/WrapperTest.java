package edu.ssafy.chap07;

public class WrapperTest {
	public static void main(String[] args) {
		int a = 10;
		Integer ia= new Integer(20);
		Integer ib = new Integer(30);
		int parseInt = ia.intValue();
		
		ia =a;
		a = ia;
		
	}
}
