package edu.ssafy.chap07.two;

public class Human extends Animal {

	public void hardStudy() {
		System.out.println("사람이 공부합니다.");
	}
	
	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("사람이 두발로 걸어요");
	}

}
