/**  
 * @Title: LoginUiTest.java
 * @Package com.lzw.test.ui
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019��7��8�� ����11:57:16
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
 * @date 2019��7��8�� ����11:57:16
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
		    frame.show(); // ��frame��ʾ���� 
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
		frame.optionPane().requireMessage("����Ա��¼�ɹ���");
		
		frame.cleanUp();
		frame = new FrameFixture(new LoginUi()); 
	    frame.show(); // ��frame��ʾ���� 
	    
		frame.textBox("name1").setText("111");
		frame.textBox("pass1").setText("111");
		frame.radioButton("adm").click();
		frame.button("log").click(); 
		frame.optionPane().requireMessage("�Ҳ�������Ա��");

		
		frame.cleanUp();
		frame = new FrameFixture(new LoginUi()); 
		frame.show(); // ��frame��ʾ���� 
		
		frame.textBox("name1").setText("1111");
		frame.textBox("pass1").setText("1111");
		frame.radioButton("dep").click();
		frame.button("log").click(); 
		frame.optionPane().requireMessage("���ŵ�¼�ɹ���");
		
		
		
		frame.cleanUp();
		frame = new FrameFixture(new LoginUi()); 
		frame.show(); // ��frame��ʾ���� 
		
		frame.textBox("name1").setText("1111");
		frame.textBox("pass1").setText("111");
		frame.radioButton("dep").click();
		frame.button("log").click(); 
		frame.optionPane().requireMessage("�����������");
		
		
		
		frame.cleanUp();
		frame = new FrameFixture(new LoginUi()); 
		frame.show(); // ��frame��ʾ���� 
		
		frame.textBox("name1").setText("123");
		frame.textBox("pass1").setText("111");
		frame.radioButton("dep").click();
		frame.button("log").click(); 
		frame.optionPane().requireMessage("�Ҳ������ţ�");
		
		
		
		frame.cleanUp();
		frame = new FrameFixture(new LoginUi()); 
		frame.show(); // ��frame��ʾ���� 
		
		frame.textBox("name1").setText("123");
		frame.textBox("pass1").setText("111");
		frame.button("log").click(); 
		frame.optionPane().requireMessage("��ѡ���¼��ݣ�");
		
		
		

		
	}

	/**
	 * Test method for {@link com.lzw.ui.LoginUi#main(java.lang.String[])}.
	 */
	

}
