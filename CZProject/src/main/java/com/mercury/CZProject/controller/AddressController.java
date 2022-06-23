package com.mercury.CZProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.CZProject.bean.Address;
import com.mercury.CZProject.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public String createAddress(@RequestBody Address address) {
		return addressService.createAddress(address);
	}
	
	@PutMapping
	public String editAddress(@RequestBody Address address) {
		return addressService.editAddress(address);
	}
}
