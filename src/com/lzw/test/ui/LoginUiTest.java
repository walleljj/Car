/**  
 * @Title: LoginUiTest.java
 * @Package com.lzw.test.ui
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019年7月8日 上午11:57:16
 */ 
package com.lzw.test.ui;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.ui.LoginUi;

/**
 * @ClassName: LoginUiTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019年7月8日 上午11:57:16
 */
public class LoginUiTest {
	 private FrameFixture frame; 

	/**
	 * @Title: setUp
	 * @Description: TODO:
	 * @return void
	 */
	@Before
	public void setUp() throws Exception {
		 frame = new FrameFixture(new LoginUi()); 
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
	 * Test method for {@link com.lzw.ui.LoginUi#LoginUi()}.
	 */
	@Test
	public void testLoginUi() {
		//fail("Not yet implemented");
		
		frame.textBox("name1").setText("123");
		frame.textBox("pass1").setText("123");
		frame.radioButton("adm").click();
		frame.button("log").click(); 
		frame.optionPane().requireMessage("管理员登录成功！");
		
		frame.cleanUp();
		frame = new FrameFixture(new LoginUi()); 
	    frame.show(); // 将frame显示出来 
	    
		frame.textBox("name1").setText("111");
		frame.textBox("pass1").setText("111");
		frame.radioButton("adm").click();
		frame.button("log").click(); 
		frame.optionPane().requireMessage("找不到管理员！");

		
		frame.cleanUp();
		frame = new FrameFixture(new LoginUi()); 
		frame.show(); // 将frame显示出来 
		
		frame.textBox("name1").setText("1111");
		frame.textBox("pass1").setText("1111");
		frame.radioButton("dep").click();
		frame.button("log").click(); 
		frame.optionPane().requireMessage("部门登录成功！");
		
		
		
		frame.cleanUp();
		frame = new FrameFixture(new LoginUi()); 
		frame.show(); // 将frame显示出来 
		
		frame.textBox("name1").setText("1111");
		frame.textBox("pass1").setText("111");
		frame.radioButton("dep").click();
		frame.button("log").click(); 
		frame.optionPane().requireMessage("部门密码错误！");
		
		
		
		frame.cleanUp();
		frame = new FrameFixture(new LoginUi()); 
		frame.show(); // 将frame显示出来 
		
		frame.textBox("name1").setText("123");
		frame.textBox("pass1").setText("111");
		frame.radioButton("dep").click();
		frame.button("log").click(); 
		frame.optionPane().requireMessage("找不到部门！");
		
		
		
		frame.cleanUp();
		frame = new FrameFixture(new LoginUi()); 
		frame.show(); // 将frame显示出来 
		
		frame.textBox("name1").setText("123");
		frame.textBox("pass1").setText("111");
		frame.button("log").click(); 
		frame.optionPane().requireMessage("请选择登录身份！");
		
		
		

		
	}

	/**
	 * Test method for {@link com.lzw.ui.LoginUi#main(java.lang.String[])}.
	 */
	

}
