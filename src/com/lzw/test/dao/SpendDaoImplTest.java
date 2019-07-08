/**  
 * @Title: SpendDaoImplTest.java
 * @Package com.lzw.test.dao
 * @Description: TODO:
 * @author lijunjiee@163.com  
 * @date 2019年7月4日 上午9:31:53
 */ 
package com.lzw.test.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.SpendDaoImpl;
import com.lzw.entity.SpendCard;

/**
 * @ClassName: SpendDaoImplTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019年7月4日 上午9:31:53
 */
/**
 	private int id;
	private String carId;
	private int spendMoney;
	private String reason;
	private Date time;
	private String notes;
 */
public class SpendDaoImplTest {
	
	SpendDaoImpl sdi = new SpendDaoImpl();

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
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.SpendDaoImpl#add(com.lzw.entity.SpendCard)}.
	 */
	@Test
	public void testAdd() {
		//fail("Not yet implemented");
		Date d = null;
		SpendCard sc = new SpendCard(9999,"甘A11133",99,"测试原因",d.valueOf("2019-07-04"),"测试数据");
		sdi.add(sc);
		assertNotNull(sdi.findById(9999));
		sdi.delet(9999);
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.SpendDaoImpl#update(com.lzw.entity.SpendCard)}.
	 */
	@Test
	public void testUpdate() {
		Date d = null;
		SpendCard sc = new SpendCard(9999,"甘A11133",99,"测试原因",d.valueOf("2019-07-04"),"测试数据");
		sdi.add(sc);
		sc.setNotes("修改后的测试数据");
		sdi.update(sc);
		sc = sdi.findById(9999);
		assertEquals("修改后的测试数据", sc.getNotes());
		sdi.delet(9999);
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.SpendDaoImpl#delet(int)}.
	 */
	@Test
	public void testDelet() {
		Date d = null;
		SpendCard sc = new SpendCard(9999,"甘A11133",99,"测试原因",d.valueOf("2019-07-04"),"测试数据");
		sdi.add(sc);
		assertNotNull(sdi.findById(9999));
		sdi.delet(9999);
		assertNull(sdi.findById(9999));
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.SpendDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<SpendCard> all = sdi.findAll();
		int allSize = all.size();
		Date d = null;
		SpendCard sc = new SpendCard(9999,"甘A11133",99,"测试原因",d.valueOf("2019-07-04"),"测试数据");
		sdi.add(sc);
		assertEquals(allSize+1, sdi.findAll().size());
		sdi.delet(9999);
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.SpendDaoImpl#findByCar(java.lang.String)}.
	 */
	@Test
	public void testFindByCar() {
		List<SpendCard> carAll = sdi.findByCar("甘A11133");
		int carAllSize = carAll.size();
		Date d = null;
		SpendCard sc = new SpendCard(9999,"甘A11133",99,"测试原因",d.valueOf("2019-07-04"),"测试数据");
		sdi.add(sc);
		assertEquals(carAllSize+1, sdi.findByCar("甘A11133").size());
		sdi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.SpendDaoImpl#findById(int)}.
	 */
	@Test
	public void testFindById() {
		Date d = null;
		SpendCard sc = new SpendCard(9999,"甘A11133",99,"测试原因",d.valueOf("2019-07-04"),"测试数据");
		sdi.add(sc);
		SpendCard sc2 = sdi.findById(9999);
		assertNotNull(sc2);
		assertEquals(sc.getNotes(), sc2.getNotes());
		sdi.delet(9999);
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.SpendDaoImpl#findByReason(java.lang.String)}.
	 */
	@Test
	public void testFindByReason() {
		List<SpendCard> carAll = sdi.findByReason("测试原因");
		int reasonAllSize = carAll.size();
		Date d = null;
		SpendCard sc = new SpendCard(9999,"甘A11133",99,"测试原因",d.valueOf("2019-07-04"),"测试数据");
		sdi.add(sc);
		assertEquals(reasonAllSize+1, sdi.findByReason("测试原因").size());
		sdi.delet(9999);
	}

}
