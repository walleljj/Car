/**  
 * @Title: DriversDaoImplTest.java
 * @Package com.lzw.test.dao
 * @Description: TODO:∂‘DriversDaoImplµƒµ•‘™≤‚ ‘
 * @author lijunjiee@163.com  
 * @date 2019ƒÍ7‘¬3»’ œ¬ŒÁ10:33:48
 */ 
package com.lzw.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lzw.daoImpl.DriversDaoImpl;
import com.lzw.entity.Drivers;

/**
 * @ClassName: DriversDaoImplTest
 * @Description: TODO:
 * @author lijunjiee@163.com
 * @date 2019ƒÍ7‘¬3»’ œ¬ŒÁ10:33:48
 */

/**
 *  private int id;//Àæª˙id
	private String type;
	private String name;//–’√˚
	private String phone;//µÁª∞
	private String state;//◊¥Ã¨
	private int isOk;// «∑Òø…”√
 
 */

public class DriversDaoImplTest {

	/**
	 * @Title: setUp
	 * @Description: TODO:
	 * @return void
	 */
	DriversDaoImpl ddi = new DriversDaoImpl();
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
	 * Test method for {@link com.lzw.daoImpl.DriversDaoImpl#add(com.lzw.entity.Drivers)}.
	 */
	@Test
	public void testAdd() {
		Drivers dr = new Drivers(9999,"≤‚ ‘≥µ","≤‚ ‘»À","99999999999","≤‚ ‘◊¥Ã¨",9999);
		ddi.add(dr);
		Drivers dr2 = ddi.findById(9999);
		assertNotNull(dr2);
		ddi.delet(9999);
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DriversDaoImpl#update(com.lzw.entity.Drivers)}.
	 */
	@Test
	public void testUpdate() {
		Drivers dr = new Drivers(9999,"≤‚ ‘≥µ","≤‚ ‘»À","99999999999","≤‚ ‘◊¥Ã¨",9999);
		ddi.add(dr);
		dr.setName("≤‚ ‘»À2");
		ddi.update(dr);
		assertEquals("≤‚ ‘»À2", ddi.findById(9999).getName());
		ddi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DriversDaoImpl#delet(int)}.
	 */
	@Test
	public void testDelet() {
		Drivers dr = new Drivers(9999,"≤‚ ‘≥µ","≤‚ ‘»À","99999999999","≤‚ ‘◊¥Ã¨",9999);
		ddi.add(dr);
		assertNotNull(ddi.findById(9999));
		ddi.delet(9999);
		assertNull(ddi.findById(9999));
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DriversDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Drivers> all = ddi.findAll();
		int allSize = all.size();
		Drivers dr = new Drivers(9999,"≤‚ ‘≥µ","≤‚ ‘»À","99999999999","≤‚ ‘◊¥Ã¨",9999);
		ddi.add(dr);
		all = ddi.findAll();
		assertEquals(allSize+1, all.size());
		ddi.delet(9999);
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DriversDaoImpl#findByIsOk(int)}.
	 */
	@Test
	public void testFindByIsOk() {
		List<Drivers> all = ddi.findByIsOk(9999);
		int allSize = all.size();
		Drivers dr = new Drivers(9999,"≤‚ ‘≥µ","≤‚ ‘»À","99999999999","≤‚ ‘◊¥Ã¨",9999);
		ddi.add(dr);
		all = ddi.findByIsOk(9999);
		assertEquals(allSize+1, all.size());
		ddi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DriversDaoImpl#findByType(java.lang.String)}.
	 */
	@Test
	public void testFindByType() {
		List<Drivers> all = ddi.findByType("≤‚ ‘≥µ");
		int allSize = all.size();
		Drivers dr = new Drivers(9999,"≤‚ ‘≥µ","≤‚ ‘»À","99999999999","≤‚ ‘◊¥Ã¨",9999);
		ddi.add(dr);
		all = ddi.findByType("≤‚ ‘≥µ");
		assertEquals(allSize+1, all.size());
		ddi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DriversDaoImpl#findById(int)}.
	 */
	@Test
	public void testFindById() {
		Drivers dr = new Drivers(9999,"≤‚ ‘≥µ","≤‚ ‘»À","99999999999","≤‚ ‘◊¥Ã¨",9999);
		ddi.add(dr);
		Drivers dr2 =  ddi.findById(9999);
		assertEquals(dr.getId(), dr2.getId());
		assertEquals(dr.getIsOk(), dr2.getIsOk());
		assertEquals(dr.getName(), dr2.getName());
		assertEquals(dr.getPhone(), dr2.getPhone());
		assertEquals(dr.getState(), dr2.getState());
		assertEquals(dr.getType(), dr2.getType());
		ddi.delet(9999);
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DriversDaoImpl#isNumber(java.lang.String)}.
	 */
	@Test
	public void testIsNumber() {
		assertTrue(ddi.isNumber("2332323"));
		assertFalse(ddi.isNumber("asdfsdaf"));
		assertFalse(ddi.isNumber(""));
		
	}

	/**
	 * Test method for {@link com.lzw.daoImpl.DriversDaoImpl#findByName(java.lang.String)}.
	 */
	@Test
	public void testFindByName() {
		List<Drivers> all = ddi.findByName("≤‚ ‘»À");
		int allSize = all.size();
		Drivers dr = new Drivers(9999,"≤‚ ‘≥µ","≤‚ ‘»À","99999999999","≤‚ ‘◊¥Ã¨",9999);
		ddi.add(dr);
		all = ddi.findByName("≤‚ ‘»À");
		assertEquals(allSize+1, all.size());
		ddi.delet(9999);
	}

}
