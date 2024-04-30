package com.akash.dataobject;

public class StudentVo {
	private String sid;
	private String name;
	private String age;
	private String address;
	
	public StudentVo() {
		
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "StudentVo [sid=" + sid + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	

}
