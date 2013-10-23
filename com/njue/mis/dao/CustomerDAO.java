/**
 * �ͻ�DAO�࣬��Ҫ�Կͻ���Ϣ���й���
 */
package com.njue.mis.dao;

import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.njue.mis.model.Customer;
import com.njue.mis.model.Goods;
import com.njue.mis.server.Server;

public class CustomerDAO extends CommonObjectDao
{

	public CustomerDAO()
	{
		super();
	}
	/**
	 * �����ݿ�������¿ͻ�
	 * @param customer ��װ�õĿͻ�
	 * @return ִ�н��
	 */
	public String addCustomer(Customer customer)
	{
		String id = (String) super.save(customer);
		return id;
	}
	/**
	 * �����ݿ���ɾ��ָ���ͻ�����Ϣ�����ڴ��������ϵ���˴������ñ��� available=0
	 * @param id ��ɾ���ͻ��ı��
	 * @return ִ�н��
	 */
	public boolean deleteCustomer(String id)
	{
		Customer customer = getCustomer(id);
		if (customer != null){
			return super.delete(customer);
		}else{
			return false;
		}
	}
	/**
	 * ��ѯ���ݿ������������Ŀͻ�
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
//	public Vector<Customer> searchCustomer(String field,String value)
//	{
//		Vector<Customer> result=new Vector<Customer>();
//		try
//		{
//			String sql="{call pr_searchCustomer(?,?)}";
//			Object[] params=new Object[]{field,value};
//			ResultSet rs=manage.executeQuery(sql, params, Constants.CALL_TYPE);
//			while(rs.next())
//			{
//				Customer customer=new Customer(rs.getString("id"),rs.getString("customerName"),rs.getString("zip"),
//									  rs.getString("address"),rs.getString("telephone"),rs.getString("fax"),
//									  rs.getString("connectionPerson"),rs.getString("phone"),rs.getString("email"),
//									  rs.getString("bank"),rs.getString("account"));
//				result.add(customer);
//			}
//			manage.closeDB();
//		}
//		catch (Exception e)
//		{
//			ErrorManager.printError("CustomerDAO.searchCustomer", e);
//		}
//		return result;
//	}
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param customer ��װ�õĿͻ�����Ϣ
	 * @return ִ�н��
	 */
	@SuppressWarnings("finally")
	public boolean updateCustomer(Customer customer)
	{
		Session session = null;
		boolean result = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			Customer tmp = (Customer) session.get(Customer.class, customer.getId());
			tmp.update(customer);
			if(!isExisted(tmp.getId())){
				session.getTransaction().commit();
				result = true;	
			}
		}catch(HibernateException ex){
			ex.printStackTrace();
			Server.logger.warn("update "+customer+" failed");
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
	/**
     * ��ʾ���еĿͻ�
     * @return �ͻ�����
     */
    @SuppressWarnings({ "unchecked", "finally" })
	public Vector<Customer> getAllCustomer()
    {
    	Session session = null;
		Vector<Customer> vec = null ;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			String sql = "from Customer order by id";
			Query query = session.createQuery(sql);
			vec = new Vector<Customer>(query.list());
			session.getTransaction().commit();
		}catch(HibernateException ex){
			ex.printStackTrace();
			Server.logger.warn("get all customer "+" failed");
			if(session != null){
				session.getTransaction().rollback();
			}
		}finally{
			if(session != null){
				session.close();
			}
			return vec;
		}
    }
    /**
     * ��ȡ�ض��ͻ�����Ϣ
     * @param id �ͻ����
     * @return ��ѯ���
     */
    public Customer getCustomer(String id)
    {
    	return (Customer) super.get(Customer.class, id);    
    }
    
    public boolean isExisted(String id){
    	return getCustomer(id) != null;
    }
    
	@SuppressWarnings({ "unchecked", "finally" })
	public Vector<Customer> getAllCustomerByCategory(int cateId){
		Session session = null;
		Vector<Customer> list = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			String sql = "from Customer where cateid = '"+cateId+"'";
			Query query = session.createQuery(sql);
			list = new Vector<Customer>(query.list());
			session.getTransaction().commit();
		}catch(HibernateException ex){
			ex.printStackTrace();
			Server.logger.warn("get all Customer by category id: "+cateId+" failed");
			if(session != null){
				session.getTransaction().rollback();
			}
			list = null;
		}finally{
			if(session != null){
				session.close();
			}
			return list;
		}
	}
}
