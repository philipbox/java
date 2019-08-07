package com.ssafy.java;

public class CodeNotFoundException extends Exception {
	public void print() {
		System.out.println("입력하신 상품번호가 존재하지 않습니다.");
	}
}
