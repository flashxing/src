package com.njue.mis.dao;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	/**
	 *��ʼһ��hibernate����
	 */
	protected void beginTransaction() throws HibernateException {
		session = sessionFactory.openSession();
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
		session.close();
	}
}