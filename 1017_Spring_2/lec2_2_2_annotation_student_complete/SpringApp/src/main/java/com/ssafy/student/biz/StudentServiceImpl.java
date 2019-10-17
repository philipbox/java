package com.ssafy.student.biz;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.student.dao.StudentDAO;
import com.ssafy.student.domain.StudentDTO;

@Component(value="sservice")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO dao;

	public StudentServiceImpl() {}
	public StudentServiceImpl(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public void insertStudent(String num, String name, String age) {
		dao.insertStudent(new StudentDTO(num, name, age));
	}

	@Override
	public void updateStudent(String num, String name, String age) {
		dao.updateStudent(new StudentDTO(num, name, age));
	}

	@Override
	public void deleteStudent(String num) {
		dao.deleteStudent(num);
	}

	@Override
	public StudentDTO selectStudentOne(String name) {
		StudentDTO dto = dao.selectStudentOne(name);
		return dto;
	}

	@Override
	public ArrayList<StudentDTO> selectStudentList() {
		ArrayList<StudentDTO> list = dao.selectStudentList();
		return list;
	}

}
