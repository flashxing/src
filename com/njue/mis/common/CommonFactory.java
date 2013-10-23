/**
 * �����࣬��������������Ķ���
 */
package com.njue.mis.common;

import com.njue.mis.interfaces.CustomerControllerInterface;
import com.njue.mis.interfaces.GoodsControllerInterface;
import com.njue.mis.interfaces.OperatorControllerInterface;
import com.njue.mis.interfaces.PortInControllerInterface;
import com.njue.mis.interfaces.PortOutServicesHandle;
import com.njue.mis.interfaces.ProviderServicesHandler;
import com.njue.mis.interfaces.SalesBackServicesHandler;
import com.njue.mis.interfaces.SalesInServicesHandler;

public class CommonFactory
{
	/**
	 * ��ȡGoodsService��Ķ���
	 * @return GoodsService��Ķ���
	 */
	public static GoodsControllerInterface getGoodsServices()
	{
		try
		{
			return (GoodsControllerInterface)Class.forName(Constants.GOODS_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getGoodsServices", e);
		}
		return null;
	}
	
	/**
	 * ��ȡCustomerServices��Ķ���
	 * @return CustomerServices��Ķ���
	 */
	public static CustomerControllerInterface getCustomerServices()
	{
		try
		{
			return (CustomerControllerInterface)Class.forName(Constants.CUSTOMER_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getCustomerServices", e);
		}
		return null;
	}
	/**
	 * ��ȡProviderServices��Ķ���
	 * @return ProviderServices��Ķ���
	 */
	public static ProviderServicesHandler getProviderServices()
	{
		try
		{
			return (ProviderServicesHandler)Class.forName(Constants.PROVIDER_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getProviderServices", e);
		}
		return null;
	}
	/**
	 * ��ȡOperatorServices��Ķ���
	 * @return OperatorServices��Ķ���
	 */
	public static OperatorControllerInterface getOperatorServices()
	{
		try
		{
			return (OperatorControllerInterface)Class.forName(Constants.OPERATOR_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getOperatorServices", e);
		}
		return null;
	}
	/**
	 * ��ȡPortInServices��Ķ���
	 * @return PortInServices��Ķ���
	 */
	public static PortInControllerInterface getPortInServices()
	{
		try
		{
			return (PortInControllerInterface)Class.forName(Constants.PORTIN_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.PortInServicesHandle", e);
		}
		return null;
	}
	/**
	 * ��ȡPortOutServices��Ķ���
	 * @return PortOutServices��Ķ���
	 */
	public static PortOutServicesHandle getPortOutServices()
	{
		try
		{
			return (PortOutServicesHandle)Class.forName(Constants.PORTOUT_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getPortOutServices", e);
		}
		return null;
	}
	
	/**
	 * ��ȡSalesBackServices��Ķ���
	 * @return SalesBackServices��Ķ���
	 */
	public static SalesInServicesHandler getSalesInServices()
	{
		try
		{
			return (SalesInServicesHandler)Class.forName(Constants.SALESIN_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.SalesInServicesHandler", e);
		}
		return null;
	}
	/**
	 * ��ȡSalesBackServices��Ķ���
	 * @return SalesBackServices��Ķ���
	 */
	public static SalesBackServicesHandler getSalesBackServices()
	{
		try
		{
			return (SalesBackServicesHandler)Class.forName(Constants.SALESBACK_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getSalesBackServices", e);
		}
		return null;
	}
}
