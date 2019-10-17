package com.ssafy.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {
//		Person p = new Person("홍길동", 21, "광산구");
//		System.out.println(p.toString());

		BeanFactory fac = new ClassPathXmlApplicationContext("/app/config/applicationContext.xml");
		
		//객체생성 방법1
//		PersonImpl per1 = fac.getBean(PersonImpl.class);
//		per1.setName("홍길동");
//		per1.setAge(21);
//		per1.setAddr("광주");
//		System.out.println(per1.toString());
		
		//객체생성 방법2
//		PersonImpl per2 = (PersonImpl) fac.getBean("person");
//		per2.setName("이경석");
//		per2.setAge(42);
//		per2.setAddr("흑석동");
		
//		MemberImpl mem = fac.getBean(MemberImpl.class);
		Member mem = (Member)fac.getBean("member");
		System.out.println(mem);
		
		
		
		
		// 기본이 싱글톤패턴인데, applicationContext.xml에서 scope를 prototype으로 바꿔주면 새롭게 생성이 된다.
	}
}
