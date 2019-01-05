package com.mspandrade.starterproject.config.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mspandrade.starterproject.service.ClientUserDetail;
import com.mspandrade.starterproject.service.UserService;

@Configuration
public class ServiceProvider {

	@Autowired
	private UserService userService;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new ClientUserDetail(userService);
	}
	
}
