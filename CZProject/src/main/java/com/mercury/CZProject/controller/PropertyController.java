package com.mercury.CZProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.CZProject.service.PropertyService;

@RestController
@RequestMapping("prperty")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
}
