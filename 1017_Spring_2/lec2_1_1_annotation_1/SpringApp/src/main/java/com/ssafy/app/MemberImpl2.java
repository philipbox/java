package com.ssafy.app;

import java.util.ArrayList;

public class MemberImpl2 implements Member {
	private int num;
	private Person p;
	private ArrayList<String> hobby;
	
	public MemberImpl2() {}
	public MemberImpl2(int num, Person p) {
		this.num = num;
		this.p = p;
	}
	public MemberImpl2(int num, Person p, ArrayList<String> hobby) {
		this.num = num;
		this.p = p;
		this.hobby = hobby;
	}
	@Override
	public void setHobby(ArrayList<String> hobby) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> getHobby() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNum1(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPerson(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Person getPerson() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "MemberImpl2 [num=" + num + ", p=" + p + ", hobby=" + hobby + "]";
	}

	
	
}
