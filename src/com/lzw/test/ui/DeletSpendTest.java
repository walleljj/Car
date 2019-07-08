package com.lzw.test.ui;

import java.sql.Date;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.SpendDaoImpl;
import com.lzw.entity.SpendCard;
import com.lzw.ui.DeletSpend;

public class DeletSpendTest {
	private FrameFixture frame;
	
	SpendDaoImpl sim=new SpendDaoImpl();
	
	SpendCard sca;
	
	@Before
	public void setUp() throws Exception {
		frame=new FrameFixture(new DeletSpend());
		frame.show();
	}

	@After
	public void tearDown() throws Exception {
		frame.cleanUp();
	}

	@SuppressWarnings("static-access")
	@Test
	public void testDeletSpend() {
//		fail("Not yet implemented");
		Date t=null;
		sca=new SpendCard(123,"甘A12345",1000,"保养",t.valueOf("2015-02-21")," ");
		sim.add(sca);
		frame.textBox("delId").setText("123");
		frame.button("cel").doubleClick();
		frame.optionPane().requireMessage("删除成功！");
		frame.cleanUp();
		
		frame=new FrameFixture(new DeletSpend());
		frame.show();
		frame.textBox("delId").setText("123");
		frame.button("cel").doubleClick();
		frame.optionPane().requireMessage("Id不存在！");
	}

}
