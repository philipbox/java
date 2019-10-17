package com.ssafy.student.domain;

//데이터 전달을 위한 객체(Data Transfer Object)
// 인자로 넘겨주기 위한 객체

public class StudentDTO {
	private String num;
	private String name;
	private String age;
	
	public StudentDTO() {}
	
	public StudentDTO(String num, String name, String age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentDTO [num=" + num + ", name=" + name + ", age=" + age + "]";
	}
}
