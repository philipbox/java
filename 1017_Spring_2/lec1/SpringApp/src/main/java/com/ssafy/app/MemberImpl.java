package com.ssafy.app;

import java.util.ArrayList;

public class MemberImpl implements Member {

	private int num;
	private Person p;
	private ArrayList<String> hobby;
	public MemberImpl() {}
	
	public MemberImpl(int num, Person p) {
		this.num = num;
		this.p = p;
	}
	
	public MemberImpl(int num, Person p, ArrayList<String> hobby) {
		this.num = num;
		this.p = p;
		this.hobby = hobby;
	}
	
	@Override
	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}
	@Override
	public ArrayList<String> getHobby() {
		return hobby;
	}
	
	
	@Override
	public void setNum1(int num) {
		this.num = num;
	}

	@Override
	public int getNum() {
		return num;
	}

	@Override
	public void setPerson(Person p) {
		this.p = p;
	}

	@Override
	public Person getPerson() {
		return p;
	}
	
	@Override
	public String toString() {
		return "MemberImpl [num=" + num + ", p=" + p + ", hobby=" + hobby + "]";
	}
}
