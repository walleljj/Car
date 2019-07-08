package com.lzw.test.ui;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.DeparDaoImpl;
import com.lzw.entity.Department;
import com.lzw.ui.DeletDepartment;

public class DeletDepartmentTest {
	private FrameFixture frame;

	DeparDaoImpl dim = new DeparDaoImpl();

	Department dep;

	@Before
	public void setUp() throws Exception {
		frame = new FrameFixture(new DeletDepartment());
		frame.show();
	}

	@After
	public void tearDown() throws Exception {
		frame.cleanUp();
	}

	@Test
	public void testDeletSpend() {
		// fail("Not yet implemented");
		dep = new Department(123, "123", "1", "1", "123455");
		dim.add(dep);
		frame.textBox("delId").setText("123");
		frame.button("cel").doubleClick();
		frame.optionPane().requireMessage("删除成功！");
		frame.cleanUp();

		frame = new FrameFixture(new DeletDepartment());
		frame.show();
		frame.textBox("delId").setText("123");
		frame.button("cel").doubleClick();
		frame.optionPane().requireMessage("删除失败，没有此部门！");
	}

}
