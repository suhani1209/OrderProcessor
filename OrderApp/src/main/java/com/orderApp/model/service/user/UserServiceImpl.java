package com.orderApp.model.service.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.orderApp.model.dao.user.User;
import com.orderApp.model.dao.user.UserDao;
import com.orderApp.model.exception.UserNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	private UserDao userDao;
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**************BEFORE SAVING USER TO DATABASE FIRST ENCODE THE PASSWORD ENTERED *************/
	@Override
	public void addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}


	@Override
	public User findById(Integer id) {
		return userDao.findById(id).orElseThrow(()-> new UserNotFoundException("User is not found"));
	}

}
