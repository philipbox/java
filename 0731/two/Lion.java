package edu.ssafy.chap07.two;

public class Lion extends Animal {
	//상속의 목적 3가지 -> 확장, 재정의, 형변환(Animal로 가능)
	
	//확장
	public void roar() {
		System.out.println("사자가 어흥해요");
	}
	
	//재정의
	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("사자가 걸어요");
	}
}
