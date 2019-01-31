package com.lzw.dao;
import java.util.List;
import com.lzw.entity.Car;

public interface CarDao {
	public int add(Car car);
	public int update(Car car);
	public int delet(String id);
	public Car findById(String id);
	public List<Car> findByVolume(int volume);
	public List<Car> findAll();
	public List<Car> findByState(String state);
	public List<Car> findByType(String type);
	public List<Car> findByIsOk(int isok);

}
