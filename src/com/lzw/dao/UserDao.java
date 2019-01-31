package com.lzw.dao;

import java.util.List;

import com.lzw.entity.User;

public interface UserDao {
	public int add(User user);
	public int update(User user);
	public int delet(int id);
	public List<User> findAll();
	public User findById(int id);
	public List<User> findByIsOk(int isOk);

}
