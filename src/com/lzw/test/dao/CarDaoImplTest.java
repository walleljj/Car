/**  
 * @Title: CarDaoImplTest.java
 * @Package com.lzw.test.dao
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019年7月2日 上午10:17:36
 */ 
package com.lzw.test.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.CarDaoImpl;
import com.lzw.entity.Car;

/**
 * @ClassName: CarDaoImplTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019年7月2日 上午10:17:36
 */
public class CarDaoImplTest {

	/**
	 * @Title: setUp
	 * @Description: TODO:
	 * @return void
	 */
	CarDaoImpl cdi = new CarDaoImpl();
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @Title: tearDown
	 * @Description: TODO:
	 * @return void
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.CarDaoImpl#add(com.lzw.entity.Car)}.
	 */
	@Test
	public void testAdd() {
		//fail("Not yet implemented");
		Date d = null;
		Car car = new Car("111","轿车",999,d.valueOf("2000-12-12"),99999,1,"空闲","111");
		Car toCar = cdi.findById("111");
		if(toCar==null) {
			cdi.add(car);
			toCar=cdi.findById("111");
		}
		assertEquals(car.getId(), toCar.getId());
		assertEquals(car.getType(), toCar.getType());
		assertEquals(car.getVolume(), toCar.getVolume());
		assertEquals(car.getInTime(), toCar.getInTime());
		assertEquals(car.getValue(), toCar.getValue());
		assertEquals(car.getIsOk(), toCar.getIsOk());
		assertEquals(car.getState(), toCar.getState());
		assertEquals(car.getNotes(), toCar.getNotes());
		cdi.delet("111");
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.CarDaoImpl#update(com.lzw.entity.Car)}.
	 */
	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
		Date d = null;
		Car car = new Car("222","轿车",1,d.valueOf("2000-12-12"),1,1,"空闲","1");
		cdi.add(car);
		Car carTo = car;
		carTo.setIsOk(0);
		cdi.update(carTo);
		Car toCar = cdi.findById("222");
		assertEquals(car.getId(), toCar.getId());
		assertEquals(car.getType(), toCar.getType());
		assertEquals(car.getVolume(), toCar.getVolume());
		assertEquals(car.getInTime(), toCar.getInTime());
		assertEquals(car.getValue(), toCar.getValue());
		assertEquals(0, toCar.getIsOk());
		assertEquals(car.getState(), toCar.getState());
		assertEquals(car.getNotes(), toCar.getNotes());
		cdi.delet("222");
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.CarDaoImpl#delet(java.lang.String)}.
	 */
	@Test
	public void testDelet() {
		Date d = null;
		Car car = new Car("333","轿车",1,d.valueOf("2000-12-12"),1,1,"空闲","1");
		cdi.add(car);
		cdi.delet("333");
		assertNull(cdi.findById("333"));
		 
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.CarDaoImpl#findById(java.lang.String)}.
	 */
	@Test
	public void testFindById() {
		//fail("Not yet implemented");
		Date d = null;
		Car car = new Car("444","轿车",1,d.valueOf("2000-12-12"),1,1,"空闲","1");
		cdi.add(car);
		Car car2 = cdi.findById("444");
		assertEquals(car.getId(), car2.getId());
		assertEquals(car.getType(), car2.getType());
		assertEquals(car.getVolume(), car2.getVolume());
		assertEquals(car.getInTime(), car2.getInTime());
		assertEquals(car.getValue(), car2.getValue());
		assertEquals(car.getIsOk(), car2.getIsOk());
		assertEquals(car.getState(), car2.getState());
		assertEquals(car.getNotes(), car2.getNotes());
		cdi.delet("444");
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.CarDaoImpl#findByVolume(int)}.
	 */
	@Test
	public void testFindByVolume() {
		
		Date d = null;
		List<Car> listV = new ArrayList<Car>();
		listV.add(new Car("551","轿车",555,d.valueOf("2000-12-12"),1,1,"空闲","1"));
		listV.add(new Car("552","轿车",555,d.valueOf("2000-12-12"),1,1,"空闲","1"));
		listV.add(new Car("553","轿车",555,d.valueOf("2000-12-12"),1,1,"空闲","1"));
		listV.add(new Car("554","轿车",555,d.valueOf("2000-12-12"),1,1,"空闲","1"));
		listV.add(new Car("555","轿车",555,d.valueOf("2000-12-12"),1,1,"空闲","1"));
		listV.add(new Car("556","轿车",555,d.valueOf("2000-12-12"),1,1,"空闲","1"));
		listV.add(new Car("557","轿车",555,d.valueOf("2000-12-12"),1,1,"空闲","1"));
		listV.add(new Car("558","轿车",555,d.valueOf("2000-12-12"),1,1,"空闲","1"));
		for (Car car : listV) {
			cdi.add(car);
		}
		List<Car> listVTo = cdi.findByVolume(555);
		assertEquals(listV.size(), listVTo.size());
		listVTo.add(new Car());
		assertEquals(listV.size()+1, listVTo.size());
		assertEquals(listV.size()+1, listVTo.size());
		assertEquals(listV.get(7).getId(), listVTo.get(7).getId());
		assertEquals(listV.get(7).getType(), listVTo.get(7).getType());
		assertEquals(listV.get(7).getVolume(), listVTo.get(7).getVolume());
		assertEquals(listV.get(7).getInTime(), listVTo.get(7).getInTime());
		assertEquals(listV.get(7).getValue(), listVTo.get(7).getValue());
		assertEquals(listV.get(7).getIsOk(), listVTo.get(7).getIsOk());
		assertEquals(listV.get(7).getState(), listVTo.get(7).getState());
		assertEquals(listV.get(7).getNotes(), listVTo.get(7).getNotes());
		for (Car car : listV) {
			cdi.delet(car.getId());
		}
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.CarDaoImpl#findByState(java.lang.String)}.
	 */
	@Test
	public void testFindByState() {
		Date d = null;
		List<Car> listV = new ArrayList<Car>();
		listV.add(new Car("551","轿车",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("552","轿车",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("553","轿车",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("554","轿车",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("555","轿车",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("556","轿车",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("557","轿车",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("558","轿车",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		for (Car car : listV) {
			cdi.add(car);
		}
		List<Car> listVTo = cdi.findByState("test");
		assertEquals(listV.size(), listVTo.size());
		listVTo.add(new Car());
		assertEquals(listV.size()+1, listVTo.size());
		assertEquals(listV.size()+1, listVTo.size());
		assertEquals(listV.get(7).getId(), listVTo.get(7).getId());
		assertEquals(listV.get(7).getType(), listVTo.get(7).getType());
		assertEquals(listV.get(7).getVolume(), listVTo.get(7).getVolume());
		assertEquals(listV.get(7).getInTime(), listVTo.get(7).getInTime());
		assertEquals(listV.get(7).getValue(), listVTo.get(7).getValue());
		assertEquals(listV.get(7).getIsOk(), listVTo.get(7).getIsOk());
		assertEquals(listV.get(7).getState(), listVTo.get(7).getState());
		assertEquals(listV.get(7).getNotes(), listVTo.get(7).getNotes());
		for (Car car : listV) {
			cdi.delet(car.getId());
		}
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.CarDaoImpl#findByIsOk(int)}.
	 */
	@Test
	public void testFindByIsOk() {
		Date d = null;
		List<Car> listV = new ArrayList<Car>();
		listV.add(new Car("551","轿车1",555,d.valueOf("2000-12-12"),1,99,"test","1"));
		listV.add(new Car("552","轿车1",555,d.valueOf("2000-12-12"),1,99,"test","1"));
		listV.add(new Car("553","轿车1",555,d.valueOf("2000-12-12"),1,99,"test","1"));
		listV.add(new Car("554","轿车1",555,d.valueOf("2000-12-12"),1,99,"test","1"));
		listV.add(new Car("555","轿车1",555,d.valueOf("2000-12-12"),1,99,"test","1"));
		listV.add(new Car("556","轿车1",555,d.valueOf("2000-12-12"),1,99,"test","1"));
		listV.add(new Car("557","轿车1",555,d.valueOf("2000-12-12"),1,99,"test","1"));
		listV.add(new Car("558","轿车1",555,d.valueOf("2000-12-12"),1,99,"test","1"));
		for (Car car : listV) {
			cdi.add(car);
		}
		List<Car> listVTo = cdi.findByIsOk(99);
		assertEquals(listV.size(), listVTo.size());
		listVTo.add(new Car());
		assertEquals(listV.size()+1, listVTo.size());
		assertEquals(listV.size()+1, listVTo.size());
		assertEquals(listV.get(7).getId(), listVTo.get(7).getId());
		assertEquals(listV.get(7).getType(), listVTo.get(7).getType());
		assertEquals(listV.get(7).getVolume(), listVTo.get(7).getVolume());
		assertEquals(listV.get(7).getInTime(), listVTo.get(7).getInTime());
		assertEquals(listV.get(7).getValue(), listVTo.get(7).getValue());
		assertEquals(listV.get(7).getIsOk(), listVTo.get(7).getIsOk());
		assertEquals(listV.get(7).getState(), listVTo.get(7).getState());
		assertEquals(listV.get(7).getNotes(), listVTo.get(7).getNotes());
		for (Car car : listV) {
			cdi.delet(car.getId());
		}
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.CarDaoImpl#findByType(java.lang.String)}.
	 */
	@Test
	public void testFindByType() {
		Date d = null;
		List<Car> listV = new ArrayList<Car>();
		listV.add(new Car("551","轿车1",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("552","轿车1",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("553","轿车1",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("554","轿车1",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("555","轿车1",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("556","轿车1",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("557","轿车1",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		listV.add(new Car("558","轿车1",555,d.valueOf("2000-12-12"),1,1,"test","1"));
		for (Car car : listV) {
			cdi.add(car);
		}
		List<Car> listVTo = cdi.findByType("轿车1");
		assertEquals(listV.size(), listVTo.size());
		listVTo.add(new Car());
		assertEquals(listV.size()+1, listVTo.size());
		assertEquals(listV.size()+1, listVTo.size());
		assertEquals(listV.get(7).getId(), listVTo.get(7).getId());
		assertEquals(listV.get(7).getType(), listVTo.get(7).getType());
		assertEquals(listV.get(7).getVolume(), listVTo.get(7).getVolume());
		assertEquals(listV.get(7).getInTime(), listVTo.get(7).getInTime());
		assertEquals(listV.get(7).getValue(), listVTo.get(7).getValue());
		assertEquals(listV.get(7).getIsOk(), listVTo.get(7).getIsOk());
		assertEquals(listV.get(7).getState(), listVTo.get(7).getState());
		assertEquals(listV.get(7).getNotes(), listVTo.get(7).getNotes());
		for (Car car : listV) {
			cdi.delet(car.getId());
		}
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.CarDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Car> all = cdi.findAll();
		int allSize = all.size();
		Date d = null;
		Car car = new Car("444","轿车",1,d.valueOf("2000-12-12"),1,1,"空闲","1");
		cdi.add(car);
		all = cdi.findAll();
		assertEquals(allSize+1, all.size());
		cdi.delet("444");
	}

}
