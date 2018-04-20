package com.niit.shopingcart.dao;

import java.util.List;

import com.niit.shopingcart.domain.Cart;

//DAO-data acess object
public interface CartDAO {

	public boolean save(Cart cart);
	
	public boolean update(Cart cart);
	
	public boolean update(String emailID);
	
	public Cart get(int id);
	
	public boolean delete(int id);
	
	public List<Cart> list(String emailID);
	
	public boolean deleteCart(String emailID);
	
}
