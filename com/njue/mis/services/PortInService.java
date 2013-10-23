package com.njue.mis.services;

import java.util.Vector;

import com.njue.mis.dao.PortInDAO;
import com.njue.mis.model.Goods;
import com.njue.mis.model.PortIn;
import com.njue.mis.model.Stock;
import com.njue.mis.server.Server;

public class PortInService {
	private PortInDAO portInDao = new PortInDAO();
	private StockService stockService = new StockService();
	private GoodsService goodsService = new GoodsService();
	
	public String addPortIn(PortIn portIn){
		String result = portInDao.addPortIn(portIn);
		if(result == null){
			Server.logger.warn("Failed to save the PortIn:"+portIn);
			return null;
		}
		String goodsId = portIn.getGoodsId();
		int shId = portIn.getStoreHouseId();
		int number = portIn.getNumber();
		Stock stock = new Stock(goodsId,shId,number);
		if(stockService.addStock(stock)<0){
			Server.logger.warn("Failed to add stock:"+stock);
			portInDao.deletePortIn(portIn);
			return null;
		}
		Goods goods = goodsService.getGoods(goodsId);
		if (goods == null){
			Server.logger.warn("Failed to get goods:"+goodsId);
			stockService.deleteStock(stock);
			portInDao.deletePortIn(portIn);
			return null;
		}
		goods.setGoodsNum(goods.getGoodsNum()+number);
		goods.setLastStockPrice(portIn.getPrice());
		if(!goodsService.updateGoods(goods)){
			Server.logger.warn("Failed to update the goods after PortIn");
			stockService.deleteStock(stock);
			portInDao.deletePortIn(portIn);
			return null;
		}
		return result;
	}
	public Vector<PortIn> getAllPortIn(){
		return portInDao.getAllPortIn();
	}
	public PortIn getPortIn(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public Vector<PortIn> searchPortInByTime(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return portInDao.searchPortInByTime(beginTime, endTime);
	}
	public Vector<PortIn> searchPortIn(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}
}
