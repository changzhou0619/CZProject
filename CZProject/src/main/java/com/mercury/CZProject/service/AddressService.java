package com.mercury.CZProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.CZProject.bean.Address;
import com.mercury.CZProject.dao.AddressDao;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;
	
	public String createAddress(Address address) {
		if(addressDao.findByPropertyid(address.getProperty().getPropertyid()) == null) {
			addressDao.save(address);
			return "create success";
		}
		return "create failed , property already set address";
	}
	
	public String editAddress(Address address) {
		Address addr = (Address) addressDao.findByPropertyid(address.getProperty().getPropertyid());
		if(addr != null) {
			address.setAddressid(addr.getAddressid());
			addressDao.save(address);
			return "edit success";
		}
		return "edit failed, no such address object";
	}
}
