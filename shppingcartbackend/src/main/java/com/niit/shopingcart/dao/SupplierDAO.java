package com.niit.shopingcart.dao;

import java.util.List;

import com.niit.shopingcart.domain.Supplier;

public interface SupplierDAO {
	
	public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);
	
	public Supplier get(String id);
	
	public boolean delete(String id);
	
	public List<Supplier>list();

}
