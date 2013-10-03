package com.njue.mis.services;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.apache.log4j.Logger;

import com.njue.mis.dao.CategoryDao;
import com.njue.mis.handler.CategoryServiceHandler;
import com.njue.mis.model.Category;
import com.njue.mis.server.Server;

public class CategoryService extends UnicastRemoteObject implements CategoryServiceHandler{
	private CategoryDao categoryDao = new CategoryDao();
	public CategoryService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.njue.mis.handler.CategoryServiceHandler#addCategory(com.njue.mis.model.Category)
	 */
	@Override
	public boolean addCategory(Category category) throws RemoteException {
		// TODO Auto-generated method stub
		Server.logger.info("add a category "+category);
		return categoryDao.saveCategory(category);
	}
	/*
	 * (non-Javadoc)
	 * @see com.njue.mis.handler.CategoryServiceHandler#delCategory(com.njue.mis.model.Category)
	 */
	@Override
	public boolean delCategory(Category category) throws RemoteException {
		// TODO Auto-generated method stub
		Server.logger.info("delete a category "+category);
		return categoryDao.delCategory(category);
	}
	/*
	 * (non-Javadoc)
	 * @see com.njue.mis.handler.CategoryServiceHandler#updateCategory(com.njue.mis.model.Category)
	 */
	@Override
	public boolean updateCategory(Category category) throws RemoteException {
		// TODO Auto-generated method stub
		Server.logger.info("update a category "+category);
		return categoryDao.updateCategory(category);
	}
	/*
	 * (non-Javadoc)
	 * @see com.njue.mis.handler.CategoryServiceHandler#getAllCategory()
	 */
	@Override
	public List<Category> getAllCategory() throws RemoteException {
		// TODO Auto-generated method stub
		return categoryDao.getAll();
	}
	/*
	 * (non-Javadoc)
	 * @see com.njue.mis.handler.CategoryServiceHandler#getCategory(int)
	 */
	@Override
	public Category getCategory(int cate_id) throws RemoteException {
		// TODO Auto-generated method stub
		return categoryDao.getCategory(cate_id);
	}
}
