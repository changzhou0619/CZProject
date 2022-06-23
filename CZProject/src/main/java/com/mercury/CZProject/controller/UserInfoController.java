package com.mercury.CZProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.CZProject.bean.UserInfo;
import com.mercury.CZProject.service.UserInfoService;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping
	public String createInfo(@RequestBody UserInfo userInfo) {
		return userInfoService.createInfo(userInfo);
	}
	
	@PutMapping
	public String editInfo(@RequestBody UserInfo userInfo) {
		return userInfoService.editInfo(userInfo);
	}
}
