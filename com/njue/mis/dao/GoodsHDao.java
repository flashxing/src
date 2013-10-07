package com.njue.mis.dao;

import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.njue.mis.model.Goods;

public class GoodsHDao extends HibernateBase{
	public boolean addGoods(Goods good){
		try{
			this.beginTransaction();
			this.session.save(good);
			this.endTransaction(true);
			return true;
		}catch(HibernateException ex){
			return false;
		}
	}
	
	public boolean deleteGoods(Goods good){
		try{
			this.beginTransaction();
			this.session.delete(good);
			this.endTransaction(true);
			return true;
		}catch(HibernateException ex){
			return false;
		}
	}
	
	public Vector<Goods> getAllGoods(){
		try{
			this.beginTransaction();
			String sql = "from Goods";
			Query query = this.session.createQuery(sql);
			@SuppressWarnings("unchecked")
			Vector<Goods> result = new Vector<Goods>(query.list());
			this.endTransaction(false);
			return result;
		}catch (HibernateException ex){
			return null;
		}
	}
	
	public Goods getGoodsInfo(String id){
		try{
			this.beginTransaction();
			Goods good = (Goods) this.session.load(Goods.class, id);
			this.endTransaction(false);
			return good;
		}catch (HibernateException ex){
			return null;
		}
	}
	
	public boolean isExisted(String id){
		try{
			Goods good = this.getGoodsInfo(id);
			if (good == null){
				return false;
			}else{
				return true;
			}
		}catch (HibernateException ex){
			return false;
		}
	}
	
	public boolean updateGoods(Goods good){
		try{
			this.beginTransaction();
			Goods goods = (Goods) this.session.load(Goods.class, good.getId());
			goods.update(good);
			this.endTransaction(true);
			return true;
		}catch (HibernateException ex){
			return false;
		}
	}
}
