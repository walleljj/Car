package com.lzw.test.ui;

import java.sql.Date;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.UseCardDaoImpl;
import com.lzw.entity.UseCard;
import com.lzw.ui.DeletUse;

public class DeletUseTest {
	private FrameFixture fram;
	private UseCardDaoImpl udi = new UseCardDaoImpl();
	UseCard usecard;
	@Before
	public void setUp() throws Exception {
		fram=new FrameFixture(new DeletUse());
		fram.show();
	}

	@After
	public void tearDown() throws Exception {
		fram.cleanUp();
	}

	@SuppressWarnings("static-access")
	@Test
	public void testDeletUse() {
		//fail("Not yet implemented");
		Date d = null;
		usecard=new UseCard(123,1,"甘A123",d.valueOf("2011-01-01"),d.valueOf("2011-01-01"),"","好","已还");
		usecard.setId(123);
		udi.add(usecard);
		fram.textBox("delId").setText("123");
		fram.button("cel").doubleClick();
		fram.optionPane().requireMessage("删除成功！");
		fram.cleanUp();
		
		fram=new FrameFixture(new DeletUse());
		fram.show();
		fram.textBox("delId").setText("123");
		fram.button("cel").doubleClick();
		fram.optionPane().requireMessage("Id不存在！");
		
	}

	

}
