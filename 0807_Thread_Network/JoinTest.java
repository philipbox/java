package edu.ssafy.chap09;
// join에 yield해봥
class JoinTest {
	public static void main(String[] args){ 
		ThreadA a=new ThreadA();
		ThreadB b=new ThreadB(a);
		b.start();
		a.start();
	}
}
class ThreadA extends Thread{
	public void run(){
		for(int i=0;i<=7;i++){
			System.out.println("쓰레드  A 실행중 "+" "+i);
			try{
				sleep(1000);
			}catch(InterruptedException e){e.printStackTrace();}
		}
	}
}
class ThreadB extends Thread{
	ThreadA a;
	public ThreadB(ThreadA a){
		this.a=a;
	}
	public void run(){
		
		System.out.println("ThreadB Start....");
		try{
			for(int i=0;i<=5;i++){
				System.err.println("쓰레드 B 실행중 "+" "+i);
				if(i==2) a.join(); //
			}
		}catch(InterruptedException e){}
	}
}
