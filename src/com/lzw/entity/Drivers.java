package com.lzw.entity;

public class Drivers {
	private int id;//司机id
	private String type;
	private String name;//姓名
	private String phone;//电话
	private String state;//状态
	private int isOk;//是否可用
	
	
	
	@Override
	public String toString() {
		return "Drivers [id=" + id + ", type=" + type + ", name=" + name + ", phone=" + phone + ", state=" + state
				+ ", isOk=" + isOk + "]";
	}
	/**
	 * 
	 */
	public Drivers() {
	}
	/**
	 * @param id
	 * @param type
	 * @param name
	 * @param phone
	 * @param state
	 * @param isOk
	 */
	public Drivers(int id, String type, String name, String phone, String state, int isOk) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.phone = phone;
		this.state = state;
		this.isOk = isOk;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getIsOk() {
		return isOk;
	}
	public void setIsOk(int isOk) {
		this.isOk = isOk;
	}
	

}
