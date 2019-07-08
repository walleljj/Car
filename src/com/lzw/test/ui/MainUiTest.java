/**  
 * @Title: MainUiTest.java
 * @Package com.lzw.test.ui
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019年7月8日 下午4:12:11
 */ 
package com.lzw.test.ui;

import static org.junit.Assert.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.CarDaoImpl;
import com.lzw.ui.MainUi;

/**
 * @ClassName: MainUiTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019年7月8日 下午4:12:11
 */
public class MainUiTest {
	private CarDaoImpl cdi = new CarDaoImpl();
	private FrameFixture frame;
	
	

	/**
	 * @Title: setUp
	 * @Description: TODO:
	 * @return void
	 */
	@Before
	public void setUp() throws Exception {
		frame = new FrameFixture(new MainUi());
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
	 * Test method for {@link com.lzw.ui.MainUi#MainUi()}.
	 * 测试显示所有车辆
	 */
	@Test
	public void testListAllCar() {
		//fail("Not yet implemented");
		frame.tabbedPane().selectTab(0);
		frame.panel("clgl").button("findCar").click();
		int cow = frame.table("table1").rowCount();
		assertEquals(cow, cdi.findAll().size());
		
		frame.cleanUp();
		frame = new FrameFixture(new MainUi());
		frame.show();
		frame.tabbedPane().selectTab(0);
		frame.comboBox("ty").selectItem(1).click();
		frame.textBox("mess").setText("甘A11133");
		frame.panel("clgl").button("findCar").click();
		cow = frame.table("table1").rowCount();
		assertEquals(cow, 1);

		frame.cleanUp();
		frame = new FrameFixture(new MainUi());
		frame.show();
		frame.tabbedPane().selectTab(0);
		frame.comboBox("ty").selectItem(2).click();
		frame.textBox("mess").setText("维修");
		frame.panel("clgl").button("findCar").click();
		cow = frame.table("table1").rowCount();
		assertEquals(cow, cdi.findByState("维修").size());
		
		frame.cleanUp();
		frame = new FrameFixture(new MainUi());
		frame.show();
		frame.tabbedPane().selectTab(0);
		frame.comboBox("ty").selectItem(3).click();
		frame.textBox("mess").setText("是");
		frame.panel("clgl").button("findCar").click();
		cow = frame.table("table1").rowCount();
		assertEquals(cow, cdi.findByIsOk(1).size());
		
	}
	

}
