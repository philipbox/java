package com.ssafy.product.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ProuctClient {
	
	public static void main(String[] args) {
//		BeanFactory fac = new ClassPathXmlApplicationContext("/app/config/productContextAnno.xml");
		BeanFactory fac = new AnnotationConfigApplicationContext(PhoneConfig.class);
		
		Phone sp = (Phone) fac.getBean("galaxyfold");
		sp.powerOn();
		sp.calls();
		sp.studyAlgo();
		sp.takePicture();
		sp.powerOff();
		System.out.println(sp.toString());
	}
}
