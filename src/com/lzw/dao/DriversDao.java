package com.lzw.dao;

import java.util.List;

import com.lzw.entity.Drivers;

public interface DriversDao {
	public int add(Drivers dri);
	public int update(Drivers dri);
	public int delet(int id);
	public List<Drivers> findAll();
	public List<Drivers> findByIsOk(int isOk);
	public List<Drivers> findByType(String type);
	public Drivers findById(int id);
	

}
