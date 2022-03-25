package com.orderapp.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.orderapp.model.dao.user.User;
import com.orderapp.model.service.user.UserService;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	private UserService userService;
	
	@Autowired
	public MyUserDetailService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user=userService.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User is not found");
		}
		return  new 
				org.springframework.security.core.userdetails
				.User(user.getUsername(), user.getPassword(),AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
	}
	
}
