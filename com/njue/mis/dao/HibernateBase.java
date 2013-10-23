package com.njue.mis.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public abstract class HibernateBase 
{
	protected SessionFactory sessionFactory;//�Ự���������ڴ����Ự
	protected Session session;//hibernate�Ự
	protected Transaction transaction; //hiberante����

	public HibernateBase()throws HibernateException
	{
		this.initHibernate();
	}
	
	// ��������
	protected void initHibernate() throws HibernateException {
		// װ�����ã�����SessionFactory����
		Configuration cfg = new Configuration();
		cfg.configure();
		 ServiceRegistry servicer = new ServiceRegistryBuilder()
		.applySettings(cfg.getProperties()).buildServiceRegistry();
		 sessionFactory = cfg.buildSessionFactory(servicer);
//		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}

	/**
	 *��ʼһ��hibernate����
	 */
	protected void beginTransaction() throws HibernateException {
		transaction = session.beginTransaction();
	}

	/**
	 *����һ��hibernate����
	 */
	protected void endTransaction(boolean commit) throws HibernateException {
		if (commit) {
			transaction.commit();
		} else {
			//�����ֻ���Ĳ���������Ҫcommit�������
			transaction.rollback();
		}
//		session.close();
	}
	@Override
	protected void finalize() throws Throwable{
		session.close();
	}
}