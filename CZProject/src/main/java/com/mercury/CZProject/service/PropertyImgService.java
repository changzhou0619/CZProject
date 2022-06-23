package com.mercury.CZProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.CZProject.bean.PropertyImg;
import com.mercury.CZProject.dao.PropertyImgDao;

@Service
public class PropertyImgService {
	
	@Autowired
	private PropertyImgDao propertyImgDao;
	
//	public String buildWithImg(List<PropertyImg> propertyimgs) {
//		propertyImgDao.save(propertyimgs);
//		return "Image Upload Success!";
//	}
	
}
