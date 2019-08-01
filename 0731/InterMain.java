package edu.ssafy.chap07;

public class InterMain {
	public static void main(String[] args) {
		InterSub s =  new InterSub();
//		s.print();
		test(s);
	}
	
	
	// interface의 관계만 보면 상속관계를 찾을 수 없는데,
	// 객체를 찾아가봐야 이 관계를 이해할 수 있다
	public static void test(InterEx3 ex) {
		InterEx1 a = (InterEx1) ex;
	}
}
