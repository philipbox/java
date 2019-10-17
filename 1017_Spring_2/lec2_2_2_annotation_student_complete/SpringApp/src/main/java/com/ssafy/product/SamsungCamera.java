package com.ssafy.product;

public class SamsungCamera implements Camera {

	@Override
	public void takePicture() {
		System.out.println("삼성카메라로 사진을 찍어요.");
	}

}
