package edu.ssafy.chap09.Network4;

import java.io.Serializable;

public class Message implements Serializable{
	String msg;
	String from;
	String to;
	
	public Message(String from, String to, String msg){
		this.from = from;
		this.to = to;
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		
		return from + "이 " + to + "에게 보낸 문자열 : " + msg;
	}
}
