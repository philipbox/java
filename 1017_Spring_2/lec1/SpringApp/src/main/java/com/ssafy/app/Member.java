package com.ssafy.app;

import java.util.ArrayList;

public interface Member {
//	int num;
//	Person person;
	
	public void setHobby(ArrayList<String> hobby);
	public ArrayList<String> getHobby();
	public void setNum1(int num);
	public int getNum();
	public void setPerson(Person p);
	public Person getPerson();
	public String toString();

}
