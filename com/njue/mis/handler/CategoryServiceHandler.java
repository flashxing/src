package com.njue.mis.handler;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.njue.mis.model.Category;

public interface CategoryServiceHandler extends Remote {
	/*
	 * @params category the category to add
	 * @returns true if save the category in the db success
	 */
	public boolean addCategory(Category category) throws RemoteException;
	/*
	 * @params category the category to delete
	 * @returns true if delete hte category in the db success
	 */
	public boolean delCategory(Category category) throws RemoteException;
	/*
	 * @params category the category to update
	 * @returns true if update the category in the db success
	 */
	public boolean updateCategory(Category category) throws RemoteException;
	/*
	 * @returns type List<category>
	 * 		get all the category from the db.
	 * 		saved in a list.
	 */
	public List<Category> getAllCategory() throws RemoteException;
	/*
	 * @params cate_id is the primary key of the category
	 * @returns an category object if there is an object in the db
	 * 		returns null if there is no object.
	 */
	public Category getCategory(int cate_id) throws RemoteException;
}
