package com.mercury.CZProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.CZProject.bean.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{
	Address findByPropertyid(int propertyid);
}
