package com.mspandrade.starterproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ClientUserDetail implements UserDetailsService{

	private UserService userService;
	
	@Autowired
	public ClientUserDetail(UserService userService) {
		setUserService(userService);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.mspandrade.starterproject.model.User user = getUserService().getUserRepository().findByUsername(username).get(0);
		
		return new User(
				user.getUsername(), 
				user.getPassword(), 
				true,//enabled 
				true,//accountNonExpired 
				true,//credentialsNonExpired 
				true,//accountNonLocked 
				getAuthories(user) //authorities
				);
	}
	
	public List<GrantedAuthority> getAuthories(com.mspandrade.starterproject.model.User user) {
		
		List<GrantedAuthority> authories = new ArrayList<GrantedAuthority>();
		
		authories.add(new GrantedAuthority() {			
			private static final long serialVersionUID = 1L;
			@Override
			public String getAuthority() {
				return "ADMIN";
			}
		});		
		return authories;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
