package com.orderApp.model.service;

import com.orderApp.model.dao.user.User;

public interface UserService {
	public User findById(Integer id);
	public void addUser(User user);
	public User findByUsername(String username);
}
