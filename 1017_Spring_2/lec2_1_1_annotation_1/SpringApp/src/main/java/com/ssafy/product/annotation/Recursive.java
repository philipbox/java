package com.ssafy.product.annotation;

import org.springframework.stereotype.Component;

@Component("recursive")
public class Recursive implements Algo {

	@Override
	public void solve() {
		System.out.println("재귀함수를 풀어요.");
	}

}
