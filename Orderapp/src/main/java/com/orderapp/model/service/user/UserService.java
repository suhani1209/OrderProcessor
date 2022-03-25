package com.orderapp.model.service.user;

import com.orderapp.model.dao.user.User;

public interface UserService {
	//FIND USER BY USER ID 
	public User findById(Integer id);
	
	//ADD USER TO DATABASE 
	public void addUser(User user);
	
	//FIND USER BY USER NAME 
	public User findByUsername(String username);
}
