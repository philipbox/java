package com.ssafy.product.annotation;

import org.springframework.stereotype.Component;

@Component("canoncam")
public class CanonCamera implements Camera {

	@Override
	public void takePicture() {
		System.out.println("캐논카메라로 사진을 찍어요.");
	}

}
