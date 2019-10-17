package com.ssafy.product;

import java.io.Serializable;

public class ApplePhone implements Phone, Serializable {

	private int price;
	private Camera camera;
	private Algo algo;
	
	public ApplePhone() {}
	
	public ApplePhone(int price, Camera camera, Algo algo) {
		super();
		this.price = price;
		this.camera = camera;
		this.algo = algo;
	}

	@Override
	public void powerOn() {
		System.out.println("애플 폰 ON");
	}

	@Override
	public void powerOff() {
		System.out.println("애플 폰 OFF");
	}

	@Override
	public void calls() {
		System.out.println("애플 폰으로 전화를 합니다");
	}

	@Override
	public void takePicture() {
		camera.takePicture();
	}

	@Override
	public void studyAlgo() {
		algo.solve();
	}

	@Override
	public String toString() {
		return "ApplePhone [price=" + price + ", camera=" + camera + ", algo=" + algo + "]";
	}
	
	
	
}
