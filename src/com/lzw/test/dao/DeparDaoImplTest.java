/**  
 * @Title: DeparDaoImplTest.java
 * @Package com.lzw.test.dao
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019年7月3日 下午9:30:19
 */ 
package com.lzw.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.dao.DepartmentDao;
import com.lzw.daoImpl.DeparDaoImpl;
import com.lzw.entity.Department;

/**
 * @ClassName: DeparDaoImplTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019年7月3日 下午9:30:19
 */
public class DeparDaoImplTest {

	/**
	 * @Title: setUp
	 * @Description: TODO:
	 * @return void
	 */
	DepartmentDao ddi = new DeparDaoImpl();
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
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DeparDaoImpl#add(com.lzw.entity.Department)}.
	 */
	@Test
	public void testAdd() {
		Department de = new Department(9999,"9999","测试部门","小李","11111111111");
		ddi.add(de);
		Department deTo = ddi.findById(9999);
		assertNotNull(deTo);
		ddi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DeparDaoImpl#update(com.lzw.entity.Department)}.
	 */
	@Test
	public void testUpdate() {
		Department de = new Department(9999,"9999","测试部门","小李","11111111111");
		ddi.add(de);
		de.setPassword("8888");
		ddi.update(de);
		Department deTo = ddi.findById(9999);
		assertEquals("8888", deTo.getPassword());
		ddi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DeparDaoImpl#delet(int)}.
	 */
	@Test
	public void testDelet() {
		Department de = new Department(9999,"9999","测试部门","小李","11111111111");
		ddi.add(de);
		assertNotNull(ddi.findById(9999));
		ddi.delet(9999);
		assertNull(ddi.findById(9999));
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DeparDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Department> all = ddi.findAll();
		int allSize = all.size();
		Department de = new Department(9999,"9999","测试部门","小李","11111111111");
		ddi.add(de);
		all = ddi.findAll();
		assertEquals(allSize+1, all.size());
		ddi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DeparDaoImpl#findById(int)}.
	 */
	@Test
	public void testFindById() {
		Department de = new Department(9999,"9999","测试部门","小李","11111111111");
		ddi.add(de);
		Department deTo = ddi.findById(9999);
		assertEquals(de.getDepartment(), deTo.getDepartment());
		assertEquals(de.getHead(), deTo.getHead());
		assertEquals(de.getId(), deTo.getId());
		assertEquals(de.getPassword(), deTo.getPassword());
		assertEquals(de.getPhone(), deTo.getPhone());
		ddi.delet(9999);

	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DeparDaoImpl#findByDe(java.lang.String)}.
	 */
	@Test
	public void testFindByDe() {
		Department de = new Department(9999,"9999","测试部门","小李","11111111111");
		ddi.add(de);
		Department deTo = ddi.findByDe("测试部门");
		assertEquals(de.getDepartment(), deTo.getDepartment());
		assertEquals(de.getHead(), deTo.getHead());
		assertEquals(de.getId(), deTo.getId());
		assertEquals(de.getPassword(), deTo.getPassword());
		assertEquals(de.getPhone(), deTo.getPhone());
		ddi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DeparDaoImpl#isNumber(java.lang.String)}.
	 */
	@Test
	public void testIsNumber() {
		DeparDaoImpl ddi2 = new DeparDaoImpl();
		
		assertTrue(ddi2.isNumber("45645646"));
		assertFalse(ddi2.isNumber("sdfsda"));
		assertFalse(ddi2.isNumber("   "));
		
	}

}
