/**  
 * @Title: UpdateCarTest.java
 * @Package com.lzw.test.ui
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019年7月8日 下午3:48:44
 */ 
package com.lzw.test.ui;

import static org.junit.Assert.*;

import java.sql.Date;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.CarDaoImpl;
import com.lzw.entity.Car;
import com.lzw.ui.UpdateCar;

/**
 * @ClassName: UpdateCarTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019年7月8日 下午3:48:44
 */
public class UpdateCarTest {
	private FrameFixture frame;
	private CarDaoImpl cdi = new CarDaoImpl();

	/**
	 * @Title: setUp
	 * @Description: TODO:
	 * @return void
	 */
	@Before
	public void setUp() throws Exception {
		frame = new FrameFixture(new UpdateCar());
		frame.show();
	}

	/**
	 * @Title: tearDown
	 * @Description: TODO:
	 * @return void
	 */
	@After
	public void tearDown() throws Exception {
		frame.cleanUp();
	}

	/**
	 * Test method for {@link com.lzw.ui.UpdateCar#UpdateCar()}.
	 */
	@Test
	public void testUpdateCar() {
		//fail("Not yet implemented");
		
		frame.textBox("cph").setText("333");
		frame.textBox("cllx").setText("大客车");
		frame.textBox("clrl").setText("5");
		frame.textBox("grsj").setText("2018-11-11");
		frame.textBox("sfky").setText("123");
		frame.textBox("cljz").setText("500000");
		frame.textBox("clzt").setText("0");
		frame.button("okUp").click();
		frame.optionPane().requireMessage("车辆不存在！\\n请检查车牌号是否正确");
		
		frame.cleanUp();
		frame = new FrameFixture(new UpdateCar());
		frame.show();
		
		Date d = null;
		cdi.add(new Car("111","轿车",999,d.valueOf("2000-12-12"),99999,1,"空闲","111"));
		frame.textBox("cph").setText("111");
		frame.textBox("cllx").setText("大客车");
		frame.textBox("clrl").setText("5");
		frame.textBox("grsj").setText("2018-11-11");
		frame.textBox("sfky").setText("123");
		frame.textBox("cljz").setText("500000");
		frame.textBox("clzt").setText("0");
		frame.button("okUp").click();
		frame.optionPane().requireMessage("修改车辆成功！");
		assertEquals(123,cdi.findById("111").getValue());
		cdi.delet("111");
	}

}
