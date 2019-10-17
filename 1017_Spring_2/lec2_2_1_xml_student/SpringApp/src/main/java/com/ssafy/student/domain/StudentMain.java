package com.ssafy.student.domain;

import java.util.ArrayList;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.student.biz.StudentService;

public class StudentMain {

	public static void main(String[] args) {
		BeanFactory fac = new ClassPathXmlApplicationContext("app/config/studentContext.xml");
		StudentService service = (StudentService) fac.getBean("sservice");
		
		service.insertStudent("1", "홍길동", "21");
		service.insertStudent("2", "고길동", "31");
		service.insertStudent("3", "둘리", "7");

		ArrayList<StudentDTO> list = service.selectStudentList();
		
		for(StudentDTO s : list)
			System.out.println(s);
		
		
	}//end main
}
