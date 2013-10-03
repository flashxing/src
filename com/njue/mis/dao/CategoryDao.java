package com.njue.mis.dao;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.njue.mis.model.Category;


public class CategoryDao extends HibernateBase {
	public boolean saveCategory(Category category)
	{
		this.beginTransaction();
		if (!isCategoryExist(category)){
			this.session.save(category);
			this.endTransaction(true);
			return true;
		}
		this.endTransaction(true);
		return false;
	}
	
	public Category getCategory(int cate_id)
	{
		this.beginTransaction();
		String sql = "from Category where cate_id = "+cate_id;
    	Query query = this.session.createQuery(sql);
		List<Category> list = query.list();
    	this.endTransaction(false);
		Category category = null;
		category = list.size()>0?list.get(0):null;
		return category;
	}
	
	public boolean delCategory(Category category)
	{
		this.beginTransaction();
		this.session.delete(category);
		this.endTransaction(true);
		return true;
	}
	
	public boolean updateCategory(Category category)
	{
		this.beginTransaction();
		Category cate = (Category) session.load(Category.class, category.getCate_id());
		cate.setCate_name(category.getCate_name());
		cate.setPrefer_id(category.getPrefer_id());
		this.endTransaction(true);
		return true;
	}
	/*
	 * @returns all category in the db
	 */
	public List<Category> getAll()
	{
		this.beginTransaction();
		String sql = "from Category as cate order by cate.prefer_id";
		Query query = this.session.createQuery(sql);
		List<Category> list = new ArrayList<Category>();
		Iterator<Category> iter = list.iterator();
		while(iter.hasNext()){
			list.add(iter.next());
		}
		this.endTransaction(false);
		return list;
	}
	
	/*
	 * check if the category is exist.
	 */
    private boolean isCategoryExist(Category category)
    {
    	String sql = "from Category where cate_name='"+category.getCate_name()+"' and prefer_id="+category.getPrefer_id();
    	Query query = this.session.createQuery(sql);
    	List<Category> list = query.list();
    	if (list.size() > 0)
    	{
    		return true;
    	}else
    	{
    		return false;
    	}
    }
	
//	public static void main(String[] args)
//	{
//		Category category = new Category();
//		category.setCate_name("≤‚ ‘1");
//		category.setPrefer_id(0);
//		CategoryDao test = new CategoryDao();
//		System.out.println(test.saveCategory(category));
//		Category cate = test.getCategory(1);
//		System.out.println(cate);
//		test.delCategory(cate);
//		cate = test.getCategory(2);
//		cate.setCate_name("≤‚ ‘2");
//		test.updateCategory(cate);
//		System.out.println(test.getCategory(2));
//	}
}
