package edu.ssafy.chap06;


// final
// 위치 : 클래스, 멤버메소드, 멤버변수앞에 쓸수 있다.
// 지역변수 앞에는 못쓴다!

// 1. 클래스 final 
// 		클래스가 마지막이다!
// 		클래스에 final이 있으면 상속이 안된다.


// 2. 메소드 final :
//		override가 안된다!


// 3. 멤버변수 final :
//		수정할 수 없다. 상수!
//		선언할 때 값을 무조건 줘야지. 고정시키고 시작하는거니까!
//		보통 대문자로 씀

// static 변수 ( 클래스화? 되어서 클래스명 . 하고 호출가능)
// Math.PI -> PI는 static final이라서 Math클래스에서 호출해서 쓰는데, final까지 있으니까 바꾸지도 못한다고!

class sub extends FinalTest {
	
}

public class FinalTest {

	public static void main(String[] args) {
		
	}
}
