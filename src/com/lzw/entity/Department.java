package com.lzw.entity;

public class Department {
	private int id;//部门ID
	private String password;//部门密码
	private String department;//部门名称
	private String head;
	private String phone;
	
	
	public Department(){
		
	}
	
	/**
	 * @param id
	 * @param password
	 * @param department
	 * @param head
	 * @param phone
	 */
	public Department(int id, String password, String department, String head, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.department = department;
		this.head = head;
		this.phone = phone;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	

}
