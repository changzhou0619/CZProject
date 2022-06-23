package com.mercury.CZProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.CZProject.bean.User;
import com.mercury.CZProject.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	//@PreAuthorize("hasRole('ADMIN')")
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	//@PreAuthorize("permitAll()")
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@PostMapping("/userregister")
	@PreAuthorize("permitAll()")
	public String userRegister(@RequestBody User user) {
		return userService.register(user);
	}
	
	@PostMapping("/applyforhost")
	@PreAuthorize("hasRole('USER')")
	public String applyForHost(@RequestBody User user) {
		//return userService.userApplyHost(user);
		return userService.userApplyHost(user);
	}
	
	@PostMapping("/hostregister")
	@PreAuthorize("permitAll()")
	public String hostregister(@RequestBody User user) {
		return userService.registerHost(user);
	}
	
	@PostMapping("/resetpassword")
	@PreAuthorize("hasAnyRole('USER', 'HOST', 'ADMIN')")
	public String resetPassword(@RequestBody User user) {
		return userService.resetPassword(user);
	}
}
