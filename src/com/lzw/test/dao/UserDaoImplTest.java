/**  
 * @Title: UserDaoImplTest.java
 * @Package com.lzw.test.dao
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019年7月4日 下午12:05:43
 */ 
package com.lzw.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.UserDaoImpl;
import com.lzw.entity.User;

/**
 * @ClassName: UserDaoImplTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019年7月4日 下午12:05:43
 */
/**
 * 
	private int id;//管理员ID
	private String password;//管理员密码
	private String name;//管理员姓名
	private String phoneNumber;//管理员电话（可以为空）
	private String sex;//管理员性别
	private int isOk;
 */
public class UserDaoImplTest {
	UserDaoImpl udi = new UserDaoImpl();

	/**
	 * @Title: setUp
	 * @Description: TODO:
	 * @return void
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * @Title: tearDown
	 * @Description: TODO:
	 * @return void
	 */
	@After
	public void tearDown() throws Exception {
		udi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UserDaoImpl#add(com.lzw.entity.User)}.
	 */
	@Test
	public void testAdd() {
		User u = new User(9999,"pass","测试人","11111111111","男",9999);
		udi.add(u);
		assertNotNull(udi.findById(9999));
		udi.delet(9999);
		assertNull(udi.findById(9999));
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UserDaoImpl#update(com.lzw.entity.User)}.
	 */
	@Test
	public void testUpdate() {
		User u = new User(9999,"pass","测试人","11111111111","男",9999);
		udi.add(u);
		u.setName("测试人2");
		udi.update(u);
		assertEquals(u.getName(), udi.findById(9999).getName());
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UserDaoImpl#delet(int)}.
	 */
	@Test
	public void testDelet() {
		User u = new User(9999,"pass","测试人","11111111111","男",9999);
		udi.add(u);
		assertNotNull(udi.findById(9999));
		udi.delet(9999);
		assertNull(udi.findById(9999));
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UserDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<User> all = udi.findAll();
		int allSize = all.size();
		User u = new User(9999,"pass","测试人","11111111111","男",9999);
		udi.add(u);
		assertEquals(allSize+1, udi.findAll().size());
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UserDaoImpl#findById(int)}.
	 */
	@Test
	public void testFindById() {
		User u = new User(9999,"pass","测试人","11111111111","男",9999);
		udi.add(u);
		User u2 = udi.findById(9999);
		assertNotNull(u2);
		assertEquals(u.getName(), u2.getName());
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UserDaoImpl#findByIsOk(int)}.
	 */
	@Test
	public void testFindByIsOk() {
		List<User> all = udi.findByIsOk(1);
		int allSize = all.size();
		User u = new User(9999,"pass","测试人","11111111111","男",1);
		udi.add(u);
		assertEquals(allSize+1, udi.findByIsOk(1).size());
	}

}
