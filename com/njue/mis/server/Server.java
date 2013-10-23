package com.njue.mis.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.njue.mis.controller.CategoryController;
import com.njue.mis.controller.CustomerController;
import com.njue.mis.controller.GoodsController;
import com.njue.mis.controller.OperatorController;
import com.njue.mis.controller.PortInController;
import com.njue.mis.controller.StoreHouseController;
import com.njue.mis.interfaces.CategoryControllerInterface;
import com.njue.mis.interfaces.CustomerControllerInterface;
import com.njue.mis.interfaces.GoodsControllerInterface;
import com.njue.mis.interfaces.OperatorControllerInterface;
import com.njue.mis.interfaces.PortInControllerInterface;
import com.njue.mis.interfaces.StoreHouseControllerInterface;
import com.njue.mis.services.CategoryService;

public class Server {
	public static Logger logger = Logger.getLogger(CategoryService.class.getName());
	public static void main(String[] args)
	{
		// BasicConfigurator replaced with PropertyConfigurator.
		PropertyConfigurator.configure("src/log4j.property");
		logger.info("Starting application.");
		try {
			logger.info("binding categoryservice");
			CategoryControllerInterface categoryService = new CategoryController();
			LocateRegistry.createRegistry(Configure.PORT);
			Naming.bind(Configure.CategoryController, categoryService);
			logger.info("bind categoryservice success");
			
			logger.info("binding operatorservice");
			OperatorControllerInterface operatorService = new OperatorController();
			Naming.bind(Configure.OperatorController, operatorService);
			logger.info("bind operatorservice success");
			
			logger.info("binding goodsservice");
			GoodsControllerInterface goodsService = new GoodsController();
			Naming.bind(Configure.GoodsController, goodsService);
			logger.info("bing goodsservice success");
			
			logger.info("binding storeHouseservice");
			StoreHouseControllerInterface storeHouseService = new StoreHouseController();
			Naming.bind(Configure.StoreHouseController,storeHouseService);
			logger.info("bing storeHouseservice success");
			
			logger.info("binding portInservice");
			PortInControllerInterface portInService = new PortInController();
			Naming.bind(Configure.PortInController,portInService);
			logger.info("bing portInservice success");
			
			logger.info("binding customerservice");
			CustomerControllerInterface customerService = new CustomerController();
			Naming.bind(Configure.CustomerController,customerService);
			logger.info("bing Customerservice success");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
