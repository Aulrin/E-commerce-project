package com.niit.shopingcart.dao;

import java.util.List;

import com.niit.shopingcart.domain.Category;


public interface CategoryDAO {
	
	public boolean save(Category category);

	public boolean update(Category category);
	
	public Category get(String string);
	
	public boolean delete(String id);
	
	public List<Category>list();


}
