/**  
 * @Title: UpdateDepartmentTest.java
 * @Package com.lzw.test.ui
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019��7��8�� ����5:13:04
 */ 
package com.lzw.test.ui;

import static org.junit.Assert.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.DeparDaoImpl;
import com.lzw.entity.Department;
import com.lzw.ui.UpdateDepartment;

/**
 * @ClassName: UpdateDepartmentTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019��7��8�� ����5:13:04
 */
public class UpdateDepartmentTest {
	private DeparDaoImpl ddi =  new DeparDaoImpl();
	private FrameFixture frame;
	/**
	 * @Title: setUp
	 * @Description: TODO:
	 * @return void
	 */
	@Before
	public void setUp() throws Exception {
		frame = new FrameFixture(new UpdateDepartment());
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
	 * Test method for {@link com.lzw.ui.UpdateDepartment#UpdateDepartment()}.
	 */
	@Test
	public void testUpdateDepartment() {
		//fail("Not yet implemented");
		ddi.add(new Department(9999,"9999","���Բ���","С��","11111111111"));
		frame.textBox("deId").setText("9999");
		frame.textBox("dePass").setText("4444");
		frame.textBox("deName").setText("���Բ���");
		frame.textBox("deRen").setText("���");
		frame.textBox("dePhone").setText("11111111111");
		frame.button("okUp").click();
		frame.optionPane().requireMessage("�޸ĳɹ���");
		ddi.delet(9999);
		
		frame.cleanUp();
		frame = new FrameFixture(new UpdateDepartment());
		frame.show();
		frame.textBox("deId").setText("9999");
		frame.textBox("dePass").setText("4444");
		frame.textBox("deName").setText("���Բ���");
		frame.textBox("deRen").setText("���");
		frame.textBox("dePhone").setText("11111111111");
		frame.button("okUp").click();
		frame.optionPane().requireMessage("û�д˲��ţ�");
	}

}
