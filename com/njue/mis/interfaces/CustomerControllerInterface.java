/**
 *�û������ӿڣ�������û����еĲ��� 
 */

package com.njue.mis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.njue.mis.model.Customer;

public interface CustomerControllerInterface extends Remote
{
	/**
	 * �����ݿ�������¿ͻ�
	 * @param customer ��װ�õĿͻ�
	 * @return ִ�н��
	 */
	public String addCustomer(Customer customer) throws RemoteException;
	
	/**
	 * �����ݿ���ɾ��ָ���ͻ�����Ϣ
	 * @param id ��ɾ���ͻ��ı��
	 * @return ִ�н��
	 */
	public boolean deleteCustomer(String id) throws RemoteException;
	/**
	 * ��ѯ���ݿ������������Ŀͻ�
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	public Vector<Customer> searchCustomer(String field,String value) throws RemoteException;
	
	/**
	 * ���¿ͻ���Ϣ
	 * @param customer ��װ�õĿͻ�����Ϣ
	 */
	public boolean updateCustomer(Customer customer) throws RemoteException;
	/**
	 * ��ȡ���пͻ���Ϣ
	 * @return �ͻ�����
	 */
	public Vector<Customer> getAllCustomer()throws RemoteException;
	/**
     * �ж��û��Ƿ����
     * @param id ��ѯ���û��㻹
     * @return ��ѯ���
     */
    public boolean isExisted(String id)throws RemoteException;
    /**
     * ��ȡ�ض��ͻ�����Ϣ
     * @param id �ͻ����
     * @return ��ѯ���
     */
    public Customer getCustomerInfo(String id)throws RemoteException;
	
}
