package com.lzw.entity;

public class User {
	
	private int id;//管理员ID
	private String password;//管理员密码
	private String name;//管理员姓名
	private String phoneNumber;//管理员电话（可以为空）
	private String sex;//管理员性别
	private int isOk;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", sex=" + sex + ", isOk=" + isOk + "]";
	}
	/**
	 * 
	 */
	public User() {
		super();
	}
	/**
	 * @param id
	 * @param password
	 * @param name
	 * @param phoneNumber
	 * @param sex
	 * @param isOk
	 */
	public User(int id, String password, String name, String phoneNumber, String sex, int isOk) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.isOk = isOk;
	}
	public int getIsOk() {
		return isOk;
	}
	public void setIsOk(int isOk) {
		this.isOk = isOk;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	

}
