package com.njue.mis.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import com.njue.mis.interfaces.PortInControllerInterface;
import com.njue.mis.model.PortIn;
import com.njue.mis.services.PortInService;

public class PortInController extends UnicastRemoteObject implements PortInControllerInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1555523111391491013L;
	private PortInService portInService = new PortInService(); 
	public PortInController() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addPortIn(PortIn portIn) {
		// TODO Auto-generated method stub
		return portInService.addPortIn(portIn);
	}

	@Override
	public Vector<PortIn> getAllPortIn() {
		// TODO Auto-generated method stub
		return portInService.getAllPortIn();
	}

	@Override
	public Vector<PortIn> searchPortIn(String field, String value) {
		// TODO Auto-generated method stub
		return portInService.searchPortIn(field,value);
	}

	@Override
	public Vector<PortIn> searchPortInByTime(String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return portInService.searchPortInByTime(beginTime,endTime);
	}

	@Override
	public PortIn getPortIn(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return portInService.getPortIn(id);
	}

}
