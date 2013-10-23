package com.njue.mis.server;

public class Configure {
	public final static String IP = "localhost:3333";
	public final static int PORT = 3333;
	public final static String CategoryController = "rmi://"+IP+"/CategoryController";
	public final static String OperatorController = "rmi://"+IP+"/OperatorController";
	public final static String GoodsController= "rmi://"+IP+"/GoodsController";
	public final static String StoreHouseController = "rmi://"+IP+"/StoreHouseController";
	public final static String PortInController = "rmi://"+IP+"/PortInController";
	public final static String CustomerController = "rmi://"+IP+"/CustomerController";
}
