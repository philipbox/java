package com.ssafy.product;

public class CanonCamera implements Camera {

	@Override
	public void takePicture() {
		System.out.println("캐논카메라로 사진을 찍어요.");
	}

}
