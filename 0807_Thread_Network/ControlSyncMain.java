package edu.ssafy.chap09;

public class ControlSyncMain {
	public static SyncData data = new SyncData();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("main 시작");
		IncrementThread in1 = new IncrementThread();
		IncrementThread in2 = new IncrementThread();
		DecrementThread de1 = new DecrementThread();
		DecrementThread de2 = new DecrementThread();

		de1.start();
		de2.start();
		in1.start();
		in2.start();
		System.out.println("main 종료");
	}
}

class SyncData {
	int i;
}

class IncrementThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (ControlSyncMain.data) {
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("증가 i : "+ControlSyncMain.data.i++);
				
				ControlSyncMain.data.notifyAll();
//				System.out.println("IncrementThread i = "
//						+ ControlSyncMain.data.i);

			}
		}
	}
}

class DecrementThread extends Thread {

	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (ControlSyncMain.data) {
				try {
					sleep(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (ControlSyncMain.data.i <= 0) {
					try {
						System.err.println("i=0  감소는 주무세요 wait");
						ControlSyncMain.data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.err.println("감소 i : "+ ControlSyncMain.data.i--);
				
//				System.out.println("DecrementThread i = "
//						+ ControlSyncMain.data.i);
			}
		}
	}
}