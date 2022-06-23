package com.mercury.CZProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercury.CZProject.bean.Profile;
import com.mercury.CZProject.bean.User;
import com.mercury.CZProject.dao.UserDao;

@Service
public class UserService {

	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getAll() {
		return userDao.findAll();
	}
	
	public String register(User user) {
		if(userDao.findByUsername(user.getUsername()) == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			List<Profile> profiles = new ArrayList<Profile>();
			profiles.add(new Profile(2));
			user.setProfiles(profiles);
			userDao.save(user);
			return "Successful register as an User";
		}
		return "Username already exist";
		
	}
	
	public String userApplyHost(User user) {
		user.setUserId(userDao.findByUsername(user.getUsername()).getUserId());
		userDao.addUserProfile(user.getUserId(), 3);
		return "Successful became a Host";
	}
	
	public String registerHost(User user) {
		if(userDao.findByUsername(user.getUsername()) == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			List<Profile> profiles = new ArrayList<Profile>();
			profiles.add(new Profile(2));
			profiles.add(new Profile(3));
			user.setProfiles(profiles);
			userDao.save(user);
			return "Successful register as an Host";
		}
		return "Username already exist";
	}
	
	public String resetPassword(User user) {
		user.setUserId(userDao.findByUsername(user.getUsername()).getUserId());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
		return "Successful reset password";
	}
}
