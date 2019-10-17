package com.ssafy.product.annotation;

import org.springframework.stereotype.Component;

@Component("dp")
public class DP implements Algo {

	@Override
	public void solve() {
		System.out.println("동적프로그래밍 알고리즘을 풀어요.");
	}

}
