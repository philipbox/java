package edu.ssafy.chap07.two;

public class Aquaman extends YoungHuman implements ISwim, IFly{
	
	@Override
	public void swimming() {
		System.out.println("아쿠아맨이 수영을 합니다.");
	}
	
	@Override
	public void fly() {
		System.out.println("아쿠아맨이 날아요.");
	}
}
