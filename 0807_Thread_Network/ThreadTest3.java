package edu.ssafy.chap09;
//현장에서 쓰는 방법
public class ThreadTest3 {
	//this - 위치한 method - class - 이 this를 돌리는 thread
	
	
	void go() {
		//this - go - ThreadTest3 - main
		Thread th = new Thread() {
			@Override
			public void run() {
				//this run - th
				System.err.println("run");
				super.run();
			}
		};
		th.start();
		
		//this - go - ThreadTest3 - Thread th
		//앞으로 이렇게 할꾸양
		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("th2");
				// this - run - Runnable - th2
			}
		});
		
		th2.start();
		
	}
	
	
	
	public static void main(String[] args) {
		new ThreadTest3().go();
	}
}
