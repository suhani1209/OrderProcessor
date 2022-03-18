package com.orderApp.model.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
