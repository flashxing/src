package com.njue.mis.dao.test;

import java.util.Vector;

import com.njue.mis.common.CommonUtil;
import com.njue.mis.dao.GoodsHDao;
import com.njue.mis.model.Goods;

import junit.framework.TestCase;

public class GoodsDaoTest extends TestCase{
	private GoodsHDao goodsDao;
	private String goods1Id;
	private Goods goods1;
	private Goods goods2;
	public void setUp(){
		goodsDao = new GoodsHDao();
		goods1 = new Goods(CommonUtil.md5s("1SP1"),"商品1","上海","长1.1m","package","SP1","promitCode","description", 12.5,"providerID",2);
		goods2 = new Goods(CommonUtil.md5s("3SP3"),"商品3","上海","长1.1m","package","SP3","promitCode","description", 12.5,"providerID",2);
		
	}
	public void tearDown(){
		
	}
	
	public void testAddAndDelete(){
		goods1Id = goodsDao.addGoods(goods1);
		assertNotNull(goods1Id);
		Goods tmp_goods = goodsDao.getGoodsInfo(goods1Id);
		assertEquals(tmp_goods.getPrice(),12.5);
		tmp_goods.setPrice(13.5);
		goodsDao.deleteGoods(tmp_goods);
		Vector<Goods> vector = goodsDao.getAllGoods();
		assertEquals(vector.size(),0);
	}

}
