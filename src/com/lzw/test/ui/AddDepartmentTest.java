/**  
 * @Title: AddDepartmentTest.java
 * @Package com.lzw.test.ui
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019年7月8日 下午4:49:58
 */ 
package com.lzw.test.ui;

import static org.junit.Assert.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.dao.DepartmentDao;
import com.lzw.daoImpl.DeparDaoImpl;
import com.lzw.ui.AddDepartment;

/**
 * @ClassName: AddDepartmentTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019年7月8日 下午4:49:58
 */
public class AddDepartmentTest {
	private DepartmentDao ddi = new DeparDaoImpl();
	private FrameFixture frame;
	/**
	 * @Title: setUp
	 * @Description: TODO:
	 * @return void
	 */
	@Before
	public void setUp() throws Exception {
		frame = new FrameFixture(new AddDepartment());
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
	 * Test method for {@link com.lzw.ui.AddDepartment#AddDepartment()}.
	 */
	@Test
	public void testAddDepartment() {
		//fail("Not yet implemented");
		frame.textBox("deId").setText("4444");
		frame.textBox("dePass").setText("4444");
		frame.textBox("deName").setText("测试部门");
		frame.textBox("deRen").setText("李俊杰");
		frame.textBox("dePhone").setText("11111111111");
		frame.button("okAdd").click();
		frame.optionPane().requireMessage("添加部门成功！");
		ddi.delet(4444);
		
		frame.cleanUp();
		frame = new FrameFixture(new AddDepartment());
		frame.show();
		frame.textBox("deId").setText("1111");
		frame.textBox("dePass").setText("4444");
		frame.textBox("deName").setText("测试部门");
		frame.textBox("deRen").setText("李俊杰");
		frame.textBox("dePhone").setText("11111111111");
		frame.button("okAdd").click();
		frame.optionPane().requireMessage("部门Id已存在！");
		
	}

}
