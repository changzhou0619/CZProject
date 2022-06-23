package com.mercury.CZProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.CZProject.dao.ProfileDao;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileDao profileDao;
}
