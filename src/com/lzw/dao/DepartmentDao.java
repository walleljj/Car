package com.lzw.dao;

import java.util.List;

import com.lzw.entity.Department;

public interface DepartmentDao {
	public int add(Department de);
	public int update(Department de);
	public int delet(int id);
	public List<Department> findAll();
	public Department findById(int id);
	public Department findByDe(String department);

}
