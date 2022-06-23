package com.mercury.CZProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mercury.CZProject.bean.User;
import com.mercury.CZProject.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userDao.findByUsername(username);
		
		if(u == null) {
			throw new UsernameNotFoundException("User:" + username + "not found!");
		}
		
		return u;
	}
}
