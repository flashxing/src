/**
 * ��������DAO
 */
package com.njue.mis.dao;

import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.njue.mis.model.PortIn;
import com.njue.mis.server.Server;

public class PortInDAO extends CommonObjectDao
{
	public PortInDAO()
	{
		super();
	}
	/**
	 * ����µĽ�����¼
	 * @param portIn ��װ�õ�PortIn����
	 * @return ִ�н��
	 */
	public String addPortIn(PortIn portIn)
	{
		String id =(String) super.save(portIn);
		return id;
	}
	public boolean deletePortIn(PortIn portIn){
		return super.delete(portIn);
	}
	
//	/**
//	 * ��ѯ���ݿ������������Ľ�����¼
//	 * @param field ��ѯ���ֶ�
//	 * @param value �����ֵ
//	 * @return ��ѯ���
//	 */
//	public Vector<PortIn> searchPortIn(String field,String value)
//	{
//		Vector<PortIn> result=new Vector<PortIn>();
//		try
//		{
//			String sql="{call pr_searchPortIn(?,?)}";
//			Object[] params=new Object[]{field,value};
//			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
//			while(rs.next())
//			{
//				PortIn portIn=new PortIn(rs.getString("id"),rs.getString("providerid"),rs.getString("goodsid"),
//									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
//									  rs.getString("inporttime"),rs.getString("operateperson"),rs.getString("comment"));
//				result.add(portIn);
//			}
//			manager.closeDB();
//		}
//		catch (Exception e)
//		{
//			ErrorManager.printError("PortInDAO.searchPortIn", e);
//		}
//		return result;
//	}
	/**
	 * ��ѯ���ݿ������������Ľ�����¼
	 * @param beginTime ��ѯ�Ŀ�ʼʱ��
	 * @param endTime  ��ѯ�Ľ���ʱ��
	 * @return ��ѯ�����
	 */
	@SuppressWarnings({ "unchecked", "finally" })
	public Vector<PortIn> searchPortInByTime(String beginTime,String endTime)
	{
		Session session = null;
		Vector<PortIn> list = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			String sql = "from PortIn where inporttime>'"+beginTime+"' and inporttime<'"+endTime+"'";
			Query query = session.createQuery(sql);
			list = new Vector<PortIn>(query.list());
			session.getTransaction().commit();
		}catch(HibernateException ex){
			ex.printStackTrace();
			Server.logger.warn("get all PortIn by time "+" failed");
			if(session != null){
				session.getTransaction().rollback();
			}
		}finally{
			if(session != null){
				session.close();
			}
			return list;
		}
	}
	
	/**
	 * ��ȡ���еĽ�����Ϣ
	 * @return ������Ϣ����
	 */
	@SuppressWarnings({ "unchecked", "finally" })
	public Vector<PortIn> getAllPortIn()
	{
		Session session = null;
		Vector<PortIn> list = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			String sql = "from PortIn order by inporttime";
			Query query = session.createQuery(sql);
			list = new Vector<PortIn>(query.list());
			session.getTransaction().commit();
		}catch(HibernateException ex){
			ex.printStackTrace();
			Server.logger.warn("get all PortIn "+" failed");
			if(session != null){
				session.getTransaction().rollback();
			}
		}finally{
			if(session != null){
				session.close();
			}
			return list;
		}
	}
//	public static void main(String[] args)
//	{
//		PortInDAO in=new PortInDAO();
//		Vector<PortIn> vector=in.searchPortInByTime("2001-08-02","2010-01-01");
//		System.err.println(vector.size());
//	}
}
