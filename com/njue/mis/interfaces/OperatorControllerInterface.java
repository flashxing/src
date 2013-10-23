/**
 * ����Ա����ӿ�
 */
package com.njue.mis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.njue.mis.model.Operator;

public interface OperatorControllerInterface extends Remote
{
	/**
	 * ��ѯ�û����������Ƿ���ȷ
	 * @param username �û���
	 * @param password ����
	 * @return ��ѯ���
	 */
	boolean loginCheck(String username,String password) throws RemoteException;
	/**
	 * �����ݿ�������µĲ���Ա
	 * @param operator ��װ�õĲ���Ա
	 * @return ִ�н��
	 */
	boolean addOperator(Operator operator) throws RemoteException;
	/**
	 * ɾ������Ա��Ϣ
	 * @param username ��ɾ���Ĳ���Ա���� 
	 * @return ִ�н��
	 */
	boolean deleteOperator(String username) throws RemoteException;
	/**
	 * �޸�����
	 * @param username ���޸ĵ��û���
	 * @param password ������
	 * @return ִ�н��
	 */
	boolean modifyPassword(String username,String password) throws RemoteException;
	/**
	 * ��ȡ�û�Ȩ��
	 * @param username �û���
	 * @return ��ѯ���
	 */
	String getPower(String username) throws RemoteException;
	/**
	 * ��ȡ����Ա������
	 * @param username �û���
	 * @return ����
	 */
	String getPassword(String username) throws RemoteException;
	/**
     * �жϲ���Ա�Ƿ����
     * @param id ��ѯ�Ĳ���Ա�ǳ�
     * @return ��ѯ���
     */
    boolean isExited(String username) throws RemoteException;
    /**
     * ��ȡ�ض�ְȨ���û���
     * @param type ����
     * @return �������
     */
    Vector<Operator> getOperator(String type) throws RemoteException;
    /**
     * ��ȡ�û�����Ϣ
     * @param userName �û���
     * @return  �û���Ϣ
     */
    Operator getOperatorInfo(String userName) throws RemoteException;
}
