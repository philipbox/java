package edu.ssafy.jdbc.chap02;

public class Student {
	private String name;
	private int hakbun;
	private String gender;
	private String birthday;
	
	public Student() {
		super();
	}

	public Student(String name, int hakbun, String gender, String birthday) {
		super();
		this.name = name;
		this.hakbun = hakbun;
		this.gender = gender;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHakbun() {
		return hakbun;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", hakbun=" + hakbun + ", gender=" + gender + ", birthday=" + birthday + "]";
	}
	
}
