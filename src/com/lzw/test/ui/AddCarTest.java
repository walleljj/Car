/**  
 * @Title: AddCarTest.java
 * @Package com.lzw.test.ui
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019年7月8日 下午2:13:16
 */ 
package com.lzw.test.ui;

import static org.junit.Assert.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.CarDaoImpl;
import com.lzw.entity.Car;
import com.lzw.ui.AddCar;
import com.lzw.ui.LoginUi;

/**
 * @ClassName: AddCarTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019年7月8日 下午2:13:16
 */
public class AddCarTest {
	 private FrameFixture frame; 
	 CarDaoImpl cdi = new CarDaoImpl();

		/**
		 * @Title: setUp
		 * @Description: TODO:
		 * @return void
		 */
		@Before
		public void setUp() throws Exception {
			 frame = new FrameFixture(new AddCar()); 
			    frame.show(); // 将frame显示出来 
			    
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
	 * Test method for {@link com.lzw.ui.AddCar#AddCar()}.
	 */
	@Test
	public void testAddCar() {
		
		frame.textBox("cph").setText("333");
		frame.textBox("cllx").setText("大客车");
		frame.textBox("clrl").setText("5");
		frame.textBox("grsj").setText("2018-11-11");
		frame.textBox("sfky").setText("123");
		frame.textBox("cljz").setText("500000");
		frame.textBox("clzt").setText("0");
		frame.button("okAdd").click();
		Car c = cdi.findById("333");
		assertNotNull(c);
		cdi.delet("333");
		frame.optionPane().requireMessage("添加车辆成功！");
		
		
		frame.cleanUp();
		frame = new FrameFixture(new AddCar()); 
	    frame.show(); // 将frame显示出来 
	    
	    frame.textBox("cph").setText("甘LF4668");
		frame.textBox("cllx").setText("大客车");
		frame.textBox("clrl").setText("5");
		frame.textBox("grsj").setText("2018-11-11");
		frame.textBox("sfky").setText("123");
		frame.textBox("cljz").setText("500000");
		frame.textBox("clzt").setText("0");
		frame.button("okAdd").click();
		
		frame.optionPane().requireMessage("车辆已存在！\n请检查车牌号是否正确");
		
		
	}

}
