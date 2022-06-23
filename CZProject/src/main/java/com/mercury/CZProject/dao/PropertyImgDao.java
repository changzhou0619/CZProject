package com.mercury.CZProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.CZProject.bean.Property;
import com.mercury.CZProject.bean.PropertyImg;

public interface PropertyImgDao extends JpaRepository<Property, Integer> {
	List<PropertyImg> findByPropertyid(int propertyid); 
}
