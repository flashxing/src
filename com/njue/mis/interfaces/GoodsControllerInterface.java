/**
 * ��Ʒ�����ӿ�
 */

package com.njue.mis.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.njue.mis.model.Goods;
import com.njue.mis.model.StorageGoods;

public interface GoodsControllerInterface extends Remote
{
	
	/**
	 * �����ݿ����������Ʒ
	 * @param goods  ��װ�õ�goods����
	 * @return  the goodsId of the goods
	 */
	public String addGoods(Goods goods) throws RemoteException;
	/**
	 * �����ݿ���ɾ����Ʒ
	 * @param id  ��ɾ����Ʒ�ı��
	 * @return  ִ�н��
	 */
	public boolean deleteGoods(Goods goods) throws RemoteException;
	/**
	 * ��ѯ���ݿ���������������Ʒ
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	public Vector<Goods> searchGoods(String field,String value)throws RemoteException;
	/**
	 * �޸���Ʒ�ļ۸�
	 * @param goods the goods to update
	 * @return ִ�н��
	 */
	public boolean updateGoods(Goods goods) throws RemoteException;
	/**
	 * ��ȡ���е���Ʒ
	 * @return ��Ʒ�ļ���
	 */
	public Vector<Goods> getAllGoods()throws RemoteException;
	/**
     * �ж���Ʒ�Ƿ����
     * @param id ��ѯ����Ʒ���
     * @return ��ѯ���
     */
    public boolean isExisted(String id) throws RemoteException;
    /**
     * ��ȡ��Ʒ����Ϣ
     * @param id ����ѯ����Ʒ�ı��
     * @return ��ѯ���
     */
    public Goods getGoods(String id)throws RemoteException;
    /**
	 * ��ѯ������Ʒ��Ϣ
	 * @return  ��ѯ�����
	 */
	public Vector<StorageGoods> getAllStorageGoods()throws RemoteException;
	/*
	 * to get all the goods of this category.
	 * @params int cateId the id of the category
	 * @return Vector<Goods> all the goods.
	 */
	public Vector<Goods> getAllGoodsByCateId(int cateId)throws RemoteException;

}
