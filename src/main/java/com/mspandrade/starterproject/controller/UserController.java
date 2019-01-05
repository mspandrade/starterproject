package com.mspandrade.starterproject.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mspandrade.starterproject.model.User;
import com.mspandrade.starterproject.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("users")
	public User store(@RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping("users")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Collection<User> all() {
		
		return null;
	}
	
}
