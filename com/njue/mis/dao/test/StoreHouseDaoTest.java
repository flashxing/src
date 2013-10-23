package com.njue.mis.dao.test;

import java.util.List;

import com.njue.mis.dao.StoreHouseDao;
import com.njue.mis.model.StoreHouse;

import junit.framework.TestCase;

public class StoreHouseDaoTest extends TestCase{
	private StoreHouseDao storeHouseDao = new StoreHouseDao();
	private StoreHouse storeHouse;
	private StoreHouse storeHouse1;
	private StoreHouse storeHouse2;
	public void setUp(){
		storeHouse = new StoreHouse();
		storeHouse.setName("�ֿ�1");
		storeHouse.setType("����1");
		
		storeHouse1 = new StoreHouse();
		storeHouse1.setName("�ֿ�2");
		
		storeHouse2 = new StoreHouse();
	}
	public void tearDown(){
		storeHouseDao.deleteStoreHouse(storeHouse);
		storeHouseDao.deleteStoreHouse(storeHouse1);
	}
	public void testVoid(){
		List<StoreHouse> list = storeHouseDao.getAll();
		assertNotNull(list);
		//test add
		int len = list.size();
		int id = storeHouseDao.saveStoreHouse(storeHouse);
		list = storeHouseDao.getAll();
		int len1 = list.size();
		assertEquals(len1-len,1);
		
		id = storeHouseDao.saveStoreHouse(storeHouse1);
		list = storeHouseDao.getAll();
		len = list.size();
		assertEquals(len-len1,1);
		//test get
		StoreHouse tmp = storeHouseDao.getStoreHouse(id);
		assertEquals(tmp.getName(),"�ֿ�2");
		
		//test update
		tmp.setName("�ֿ�3");
		assertEquals(storeHouseDao.updateStoreHouse(tmp),true);
		
		tmp = storeHouseDao.getStoreHouse(id);
		assertEquals(tmp.getName(),"�ֿ�3");
		
		//test delete
		storeHouseDao.deleteStoreHouse(tmp);
		len1 = list.size();
		assertEquals(len-len1,1);
		
		//test save
		id = storeHouseDao.saveStoreHouse(storeHouse2);
		assertEquals(id,-1);
	}
}
