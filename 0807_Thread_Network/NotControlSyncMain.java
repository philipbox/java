package edu.ssafy.chap09;

public class NotControlSyncMain {
	static NotSyncData data = new NotSyncData();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main 시작");
		IncreThread in1 = new IncreThread();
		IncreThread in2 = new IncreThread();
		DecreThread de1 = new DecreThread();
		DecreThread de2 = new DecreThread();

		de1.start();
		de2.start();
		in1.start();
		in2.start();
		System.out.println("메인종료");
	}

}

class NotSyncData {
	int i;
}

class IncreThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (NotControlSyncMain.data) {
				NotControlSyncMain.data.i++;
			}
			System.out.println("IncreThread i = " + NotControlSyncMain.data.i);
		}
	}
}

class DecreThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (NotControlSyncMain.data) {
				NotControlSyncMain.data.i--;
			}
			System.out.println("DecreThread i = " + NotControlSyncMain.data.i);
		}
	}
}