package com.lzw.entity;

import java.sql.Date;

public class UseCard {
	private int id;
	private int departmentId;
	private String carId;
	private Date startTime;
	private Date endTime;
	private String head;
	private String driverName;
	private String notes;
	
	
	/**
	 * 
	 */
	public UseCard() {
	}
	/**
	 * @param id
	 * @param departmentId
	 * @param carId
	 * @param startTime
	 * @param endTime
	 * @param head
	 * @param driverName
	 * @param notes
	 */
	public UseCard(int id, int departmentId, String carId, Date startTime, Date endTime, String head, String driverName,
			String notes) {
		this.id = id;
		this.departmentId = departmentId;
		this.carId = carId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.head = head;
		this.driverName = driverName;
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	

}
