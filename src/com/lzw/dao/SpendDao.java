package com.lzw.dao;

import java.util.List;

import com.lzw.entity.SpendCard;

public interface SpendDao {
	public int add(SpendCard sc);
	public int update(SpendCard sc);
	public int delet(int id);
	public List<SpendCard> findAll();
	public List<SpendCard> findByCar(String carId);

}
