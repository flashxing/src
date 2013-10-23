package com.njue.mis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.njue.mis.server.Server;

public class HibernateUtil {

	private static SessionFactory factory;
	
	static {
		try {
			Configuration cfg = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).buildServiceRegistry();
			factory = cfg.buildSessionFactory(serviceRegistry);
		}
		catch(Exception e) {
			e.printStackTrace();
			Server.logger.warn("Failed to create session factory");
		}
	}
	
	/**
	 * ��ȡ�Ự����
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	/**
	 * ����һ���Ự������
	 * @return Session
	 */
	public static Session getSession() {
		return factory.openSession();
	}
	
	/**
	 * �رջỰ
	 * @param session
	 */
	public static void closeSession(Session session){
		if(session != null){
			if(session.isOpen()){
				session.close();
			}
		}
	}
}
