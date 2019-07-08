package com.lzw.test.ui;

import java.sql.Date;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.CarDaoImpl;
import com.lzw.entity.Car;
import com.lzw.ui.DeletCar;

public class DeletCarTest {
	private FrameFixture frame;
	CarDaoImpl cim=new CarDaoImpl();
	Car car;
	@Before
	public void setUp() throws Exception {
		frame = new FrameFixture(new DeletCar());
		frame.show();
	}

	@After
	public void tearDown() throws Exception {
		frame.cleanUp();
	}

	@SuppressWarnings("static-access")
	@Test
	public void testDeletCar() {
		//fail("Not yet implemented");
		Date t = null;
		car=new Car("12345","�ͳ�",4,t.valueOf("2015-01-21"),50000,1,"good","��");
		cim.add(car);
		frame.textBox("carId").setText("12345");
		frame.button("del").doubleClick();
		frame.optionPane().requireMessage("ɾ���ɹ���");
		frame.cleanUp();
		
		frame = new FrameFixture(new DeletCar());
		frame.show();
		frame.textBox("carId").setText("12345");
		frame.button("del").doubleClick();
		frame.optionPane().requireMessage("���������ڻ�״̬��֧��ɾ����\n���鳵�ƺ��Ƿ���ȷ");
		
	}

}
