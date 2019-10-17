package com.ssafy.product.annotation;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="apple")
public class ApplePhone implements Phone, Serializable {
	@Value(value="100")
	private int price;
	@Autowired	// SamsungCamera같은 경우는 괜찮은데, Camera같은 경우는 삼성인지 캐논인지 모르니까 아래 Qualifier가 필요하다.
	@Qualifier("canoncam")
	private Camera camera;
	@Autowired
	@Qualifier("dp")
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
