package com.njue.mis.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;

import com.njue.mis.handler.CategoryServiceHandler;
import com.njue.mis.handler.OperatorServicesHandler;
import com.njue.mis.model.Category;
import com.njue.mis.services.CategoryService;
import com.njue.mis.services.OperatorServices;

public class Server {
	public static Logger logger = Logger.getLogger(CategoryService.class.getName());
	public static void main(String[] args)
	{
		// BasicConfigurator replaced with PropertyConfigurator.
		PropertyConfigurator.configure("src/log4j.property");
		logger.info("Starting application.");
		try {
			logger.info("binding categoryservice");
			CategoryServiceHandler categoryService = new CategoryService();
			LocateRegistry.createRegistry(Configure.PORT);
			Naming.bind(Configure.CategoryService, categoryService);
			logger.info("bind categoryservice success");
			
			logger.info("binding operatorservice");
			OperatorServicesHandler operatorService = new OperatorServices();
			Naming.bind(Configure.OperatorService, operatorService);
			logger.info("bind operatorservice success");
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
