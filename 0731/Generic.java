package edu.ssafy.chap07;

public class Generic <T> {
	private T i;
	public void setI(T... i) {
		this.i = i[0];
	}
	public T getI() {
		return i;
	}
}
