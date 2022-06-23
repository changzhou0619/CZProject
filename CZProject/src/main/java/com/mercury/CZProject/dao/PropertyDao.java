package com.mercury.CZProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.CZProject.bean.Property;

public interface PropertyDao extends JpaRepository<Property, Integer> {
	
	Property findByPropertyid(int propertyid);
	
	Property findByHostid(int hostid);
	
	Property findByCapacity_maxGreaterThanEqual(int capacity_max);
	
	Property findByAccessible(boolean accessible);	
}
