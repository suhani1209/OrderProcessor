package com.orderapp.model.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{
	
	//METHOD FOR FINDING USER BY USERNAME
	public User findByUsername(String username);
}
