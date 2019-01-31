package com.lzw.dao;

import java.sql.Date;
import java.util.List;

import com.lzw.entity.UseCard;

public interface UseCardDao {
	public int add(UseCard uc);
	public int update(UseCard uc);
	public int delet(int id);
	public List<UseCard> findAll();
	public List<UseCard> findByDe(String de);
	public List<UseCard> findByCar(String carId);
	public List<UseCard> findByTime(Date be,Date to);

}
