package com.lzw.entity;

import java.sql.Date;

public class Car {
	private String id;//车牌
	private String type;//车辆类型
	private int volume;//车辆容量
	private Date inTime;//车辆购入时间
	private int value;//车辆价值
	private int isOk;//车辆是否可用0不可用，1可用
	private String state;//车辆状态
	private String notes;//备注（可为空）	
	public Car() {
		
	}
	public Car(String id, String type, int volume, Date inTime, int value, int isOk, String state, String notes) {
		this.id = id;
		this.type = type;
		this.volume = volume;
		this.inTime = inTime;
		this.value = value;
		this.isOk = isOk;
		this.state = state;
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", type=" + type + ", volume=" + volume + ", inTime=" + inTime + ", value=" + value
				+ ", isOk=" + isOk + ", state=" + state + ", notes=" + notes + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getIsOk() {
		return isOk;
	}
	public void setIsOk(int isOk) {
		this.isOk = isOk;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
