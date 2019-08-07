package edu.ssafy.chap09;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Main Thread Start");

		
		myThread th = new myThread();
		//start를하면 stack에 run이 만들어지니까 start먼저 해줘야해.
		th.start();
		
		
		System.out.println("5초간 대기후 MyThread를 종료합니다.");
		Thread.sleep(5*1000);
		th.interrupt();
		//이게 먼저 출력이 되지? Main thread가 끝나고나서  MyThread의 run이 실행된당!!
		System.out.println("Main Thread End");
		
	}
}

class myThread extends Thread{
	
	@Override
	public void run() {
		int i=1;
		try {
			while(true) {
			sleep(1*1000);
			System.out.println("MYTHREAD");
		} 
		
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println("resource release");
		}
		
	}
}