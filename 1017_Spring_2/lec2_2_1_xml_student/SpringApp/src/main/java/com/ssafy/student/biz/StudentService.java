package com.ssafy.student.biz;

import java.util.ArrayList;

import com.ssafy.student.domain.StudentDTO;

//메인쪽에서 값을 넘겨줄거야.
public interface StudentService {

	public void insertStudent(String num, String name, String age);
	public void updateStudent(String name, String age, String num);
	public void deleteStudent(String num);
	public StudentDTO selectStudentOne(String name);
	public ArrayList<StudentDTO> selectStudentList();
	
}
