/**  
 * @Title: UseCardDaoImplTest.java
 * @Package com.lzw.test.dao
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019年7月4日 上午10:02:12
 */ 
package com.lzw.test.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.lzw.daoImpl.UseCardDaoImpl;
import com.lzw.entity.UseCard;

/**
 * @ClassName: UseCardDaoImplTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019年7月4日 上午10:02:12
 */
/**
 	private int id;
	private int departmentId;
	private String carId;
	private Date startTime;
	private Date endTime;
	private String head;
	private String driverName;
	private String notes;
 */
public class UseCardDaoImplTest {
	UseCardDaoImpl ucdi = new UseCardDaoImpl();

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
		ucdi.delet(9999);
		ucdi.delet(99999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UseCardDaoImpl#add(com.lzw.entity.UseCard)}.
	 */
	@Test
	public void testAdd() {
		Date d = null;
		UseCard uc = new UseCard(9999,9999,"9999",d.valueOf("2019-07-04"),d.valueOf("2019-04-05"),"测试人","测试司机","测试数据");
		ucdi.add(uc);
		UseCard uc2 = ucdi.findById(9999);
		assertNotNull(uc2);
		ucdi.delet(9999);
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UseCardDaoImpl#update(com.lzw.entity.UseCard)}.
	 */
	@Test
	public void testUpdate() {
		Date d = null;
		UseCard uc = new UseCard(9999,2222,"9999",d.valueOf("2019-07-04"),d.valueOf("2019-04-05"),"测试人","测试司机","测试数据");
		ucdi.add(uc);
		uc.setNotes("测试数据二");
		ucdi.update(uc);
		assertEquals(uc.getNotes(), ucdi.findById(9999).getNotes());
		ucdi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UseCardDaoImpl#delet(int)}.
	 */
	@Test
	public void testDelet() {
		Date d = null;
		UseCard uc = new UseCard(9999,2222,"9999",d.valueOf("2019-07-04"),d.valueOf("2019-04-05"),"测试人","测试司机","测试数据");
		ucdi.add(uc);
		assertNotNull(ucdi.findById(9999));
		ucdi.delet(9999);
		assertNull(ucdi.findById(9999));
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UseCardDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<UseCard> all = ucdi.findAll();
		int allSize = all.size();
		Date d = null;
		UseCard uc = new UseCard(9999,9999,"9999",d.valueOf("2019-07-04"),d.valueOf("2019-04-05"),"测试人","测试司机","测试数据");
		ucdi.add(uc);
		assertEquals(allSize+1, ucdi.findAll().size());
		ucdi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UseCardDaoImpl#findByDe(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testFindByDe() {
		
		Date d = null;
		UseCard uc = new UseCard(9999,2222,"9999",d.valueOf("2019-07-04"),d.valueOf("2019-04-05"),"测试人","测试司机","测试数据");
		ucdi.add(uc);
		List<UseCard> all = ucdi.findByDe("2222");
		int allSize = all.size();
		UseCard uc2 = new UseCard(99999,2222,"9999",d.valueOf("2019-07-04"),d.valueOf("2019-04-05"),"测试人","测试司机","测试数据");
		ucdi.add(uc2);
		assertEquals(allSize+1, ucdi.findByDe("2222").size());
		ucdi.delet(9999);
		ucdi.delet(99999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UseCardDaoImpl#findByCar(java.lang.String)}.
	 */
	@Test
	public void testFindByCar() {
		List<UseCard> all = ucdi.findByCar("9999");
		int allSize = all.size();
		Date d = null;
		UseCard uc = new UseCard(9999,2222,"9999",d.valueOf("2019-07-04"),d.valueOf("2019-04-05"),"测试人","测试司机","测试数据");
		ucdi.add(uc);
		assertEquals(allSize+1, ucdi.findByCar("9999").size());
		ucdi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UseCardDaoImpl#findByTime(java.sql.Date, java.sql.Date)}.
	 */
	@Ignore
	@Test
	public void testFindByTime() {
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.UseCardDaoImpl#findById(int)}.
	 */
	@Test
	public void testFindById() {
		Date d = null;
		UseCard uc = new UseCard(9999,9999,"9999",d.valueOf("2019-07-04"),d.valueOf("2019-04-05"),"测试人","测试司机","测试数据");
		ucdi.add(uc);
		UseCard uc2 = ucdi.findById(9999);
		assertNotNull(uc2);
		assertEquals(uc.getNotes(), uc2.getNotes());
		
	}

}
