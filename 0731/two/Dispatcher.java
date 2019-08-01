package edu.ssafy.chap07.two;

public class Dispatcher {
	
	public Dispatcher() {
		
	}
	
	
	public void go() {
		Aquaman aq = new Aquaman();
		toWalk(aq);
		toSwimming(aq);
		toFly(aq);	
		
		//추상클래스라 안댐.
////		Animal a = new Animal();
//		Eagle ea = new Eagle();
//		Lion li = new Lion();
//		Human a = new Human();
//		YoungHuman b = new YoungHuman();
//		
//		toWalk(b);
//		toWalk(ea);
//		
//		toFly(b);
//		toFly(ea);
	}
	
	private void toSwimming(ISwim s) {
		s.swimming();
	}
	
	private void toFly(IFly f) {
		f.fly();
	}
	
	private void toWalk(Animal a) {
		a.walk();
	}
	
	
	public static void main(String[] args) {
		new Dispatcher().go();;
	}

}
