package com.ssafy.student.domain;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.student.biz.StudentService;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		BeanFactory fac = new ClassPathXmlApplicationContext("app/config/studentContextAnno.xml");
		BeanFactory fac = new AnnotationConfigApplicationContext(StudentConfig.class);

		StudentService smgr = (StudentService) fac.getBean("sservice");

//		smgr.insertStudent("1", "홍길동", "21");
//		smgr.insertStudent("2", "고길동", "31");
//		smgr.insertStudent("3", "둘리", "7");
//		smgr.insertStudent("4", "승우띠", "15");
		ArrayList<StudentDTO> list = null;
		StudentDTO student = null;
		String num;
		String name;
		String age;
		out:while (true) {
			System.out.println("================================================");
			System.out.println("1.학생추가   2.학생삭제   3.학생수정   4.학생검색   5.학생목록   0.종료");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("학생의 '번호  이름  나이'를 입력해주세요.");
				num = sc.next();
				name = sc.next();
				age = sc.next();
				smgr.insertStudent(num, name, age);
				break;
			case 2:
				System.out.println("삭제할 학생의 번호를 입력해주세요.");
				num = sc.next();
				smgr.deleteStudent(num);
				break;
			case 3:
				System.out.println("수정할 학생의 정보'번호  이름  나이'를 입력해주세요.");
				num = sc.next();
				name = sc.next();
				age = sc.next();
				smgr.updateStudent(num, name, age);
				break;
			case 4:
				System.out.println("검색할 학생의 이름을 입력해주세요.");
				name = sc.next();
				student = smgr.selectStudentOne(name);
				System.out.println("번호:" +student.getNum() +"  이름:"+student.getName() +"  나이:"+student.getAge());
				break;
			case 5:
				System.out.println("***학생목록***");
				list = smgr.selectStudentList();
				for (StudentDTO s : list)
					System.out.println(s);
				break;
			default:
				break out;
			}// end switch
		}

//		for (StudentDTO s : list)
//			System.out.println(s);

	}// end main
}
