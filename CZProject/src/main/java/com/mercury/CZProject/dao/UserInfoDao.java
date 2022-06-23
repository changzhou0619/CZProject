package com.mercury.CZProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.CZProject.bean.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer>{

	UserInfo findByUser(int userid);
}
