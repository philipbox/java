package edu.ssafy.jdbc.chap02;

import java.util.ArrayList;

public class Test1 {
	public static void main(String[] args) {
			DBManager man = null;
					
			man = new DBManager();
			man.insertStudent(1, "홍길동", "남", "19880101");
			
			ArrayList<Student> list = man.queryStudent();
			for(Student s : list) {
				System.out.println(s);
			}
			
			man.close();
	}
}
