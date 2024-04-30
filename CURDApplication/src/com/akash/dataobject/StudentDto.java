package com.akash.dataobject;

public class StudentDto {
	private Integer sid;
	private String name;
	private Integer age;
	private String address;
	
	public StudentDto() {
		
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentDto [sid=" + sid + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
	

}
