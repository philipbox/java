package com.ssafy.product;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProuctClient {
	
	public static void main(String[] args) {
		BeanFactory fac = new ClassPathXmlApplicationContext("/app/config/productContext.xml");
//		Phone ap = (Phone) fac.getBean("applephone");
//		ap.powerOn();
//		ap.calls();
//		ap.studyAlgo();
//		ap.takePicture();
//		ap.powerOff();
		
		// runs as -> configuration에서 arguments samsungphone 또는 applephone 써주면 그거에 따른 객체가 호출된다.
		Phone sp = (Phone) fac.getBean(args[0]);
		sp.powerOn();
		sp.calls();
		sp.studyAlgo();
		sp.takePicture();
		sp.powerOff();
		System.out.println(sp.toString());
		
		
		
	}
}
