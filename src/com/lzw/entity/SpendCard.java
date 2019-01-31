package com.lzw.entity;

import java.sql.Date;

public class SpendCard {
	private int id;
	private String carId;
	private int spendMoney;
	private String reason;
	private Date time;
	private String notes;
	/**
	 * 
	 */
	public SpendCard() {
		super();
	}
	/**
	 * @param id
	 * @param carId
	 * @param spendMoney
	 * @param reason
	 * @param time
	 * @param notes
	 */
	public SpendCard(int id, String carId, int spendMoney, String reason, Date time, String notes) {
		super();
		this.id = id;
		this.carId = carId;
		this.spendMoney = spendMoney;
		this.reason = reason;
		this.time = time;
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public int getSpendMoney() {
		return spendMoney;
	}
	public void setSpendMoney(int spendMoney) {
		this.spendMoney = spendMoney;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
