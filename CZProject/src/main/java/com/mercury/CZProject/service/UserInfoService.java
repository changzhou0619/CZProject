package com.mercury.CZProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.CZProject.bean.User;
import com.mercury.CZProject.bean.UserInfo;
import com.mercury.CZProject.dao.UserInfoDao;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	public String createInfo(UserInfo userInfo) {
		if(userInfoDao.findById(userInfo.getUser().getUserId()) == null) {
			userInfoDao.save(userInfo);
			return "Create Info successed!";
		}
		return "Create Info failed!";
	}
	
	public String editInfo(UserInfo userInfo) {
		UserInfo useri = (UserInfo) userInfoDao.findById(userInfo.getUser().getUserId()).get();
		if(useri != null) {
			userInfo.setId(useri.getId());
			userInfoDao.save(userInfo);
			return "Edit Info successed!";
		}
		return "Edit Info failed!";
	}
}
