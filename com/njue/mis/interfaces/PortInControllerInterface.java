/**
 * ��������ӿ�
 */
package com.njue.mis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.njue.mis.model.PortIn;

public interface PortInControllerInterface extends Remote
{
	/**
	 * ����µĽ�����¼
	 * @param portIn ��װ�õ�PortIn����
	 * @return ִ�н��
	 */
	public String addPortIn(PortIn portIn) throws RemoteException;
	
	/**
	 * ��ȡ���еĽ�����Ϣ
	 * @return ������Ϣ����
	 */
	public Vector<PortIn> getAllPortIn() throws RemoteException;
	/**
	 * ��ѯ���ݿ������������Ľ�����¼
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	public Vector<PortIn> searchPortIn(String field,String value) throws RemoteException;
	/**
	 * ��ѯ���ݿ������������Ľ�����¼
	 * @param beginTime ��ѯ�Ŀ�ʼʱ��
	 * @param endTime  ��ѯ�Ľ���ʱ��
	 * @return ��ѯ�����
	 */
	public Vector<PortIn> searchPortInByTime(String beginTime,String endTime) throws RemoteException;
	/**
	 * �жϽ�������Ƿ����
	 * @param id 
	 * @return
	 */
	public PortIn getPortIn(String id) throws RemoteException;
}
