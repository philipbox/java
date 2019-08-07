package edu.ssafy.chap09;

//방법중 하나, 현장에서 이렇게는 안씀.
public class ThreadTest2 {
	public static void main(String[] args) {
		Runnable r = new MyRun();
		Thread th = new Thread(r);
		th.start();
	}
}

class MyRun implements Runnable {
	@Override
	public void run() {
		System.out.println("MyRun");
	}
}