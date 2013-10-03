package com.njue.mis.server;

public interface Configure {
	public final String IP = "localhost:3333";
	public final int PORT = 3333;
	public final String CategoryService = "rmi://"+IP+"/CategoryService";
	public final String OperatorService = "rmi://"+IP+"/OperatorService";
}
