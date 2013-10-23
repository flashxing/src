package com.njue.mis.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.njue.mis.server.Server;

public class CommonObjectDao {
	@SuppressWarnings("finally")
	protected Serializable save(Object object){
		Session session = null;
		Serializable result = -1;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			result = session.save(object);
			session.getTransaction().commit();
		}catch(HibernateException ex){
			ex.printStackTrace();
			Server.logger.warn("Save "+object+" failed");
			if(session != null){
				session.getTransaction().rollback();
			}
			result = null;
		}finally{
			if(session != null){
				session.close();
			}
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	protected Object get(@SuppressWarnings("rawtypes") Class myclass, Serializable id)
	{
		Session session = null;
		Object obj = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			obj = session.get(myclass, id);
			session.getTransaction().commit();
		}catch(HibernateException ex){
			ex.printStackTrace();
			Server.logger.warn("get "+id+" failed");
			if(session != null){
				session.getTransaction().rollback();
			}
		}finally{
			if(session != null){
				session.close();
			}
			return obj;
		}
	}
	
	@SuppressWarnings("finally")
	protected boolean delete(Object object)
	{
		Session session = null;
		boolean result = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			result = true;
		}catch(HibernateException ex){
			ex.printStackTrace();
			Server.logger.warn("delete "+object+" failed");
			if(session != null){
				session.getTransaction().rollback();
			}
		}finally{
			if(session != null){
				session.close();
			}
			return result;
		}
	}
}
