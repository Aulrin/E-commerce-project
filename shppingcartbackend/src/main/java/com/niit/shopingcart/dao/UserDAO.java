package com.niit.shopingcart.dao;

import java.util.List;

import com.niit.shopingcart.domain.User;

//DAO -Data Access Object
public interface UserDAO {

	//create new user
	public boolean save(User user);

	//update the existing user
	public boolean update(User user);

	//get the user details
	public User get(String emailID);

	//delete the user details
	public boolean delete(String emailID);
	
	//get all user details
	public List<User>list();
	
	//validate user with emailid and password
	public User validate(String emailID, String password);
	
}
