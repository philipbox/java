package com.ssafy.app;

public class PersonImpl implements Person {
	private String name;
	private int age;
	private String addr;

	public PersonImpl() {}

	public PersonImpl(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public void init() {
		System.out.println("personImpl init");
	}

	public void close() {
		System.out.println("personImpl close");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "PersonImpl [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}
