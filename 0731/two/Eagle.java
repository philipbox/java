package edu.ssafy.chap07.two;

public class Eagle extends Animal implements IFly{
	
	public void fly() {
		System.out.println("독수리가 날아요");
	}
	
	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("독수리가 걸어요");
	}
}
