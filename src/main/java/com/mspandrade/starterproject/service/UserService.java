package com.mspandrade.starterproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mspandrade.starterproject.model.User;
import com.mspandrade.starterproject.repository.UserRepository;

@Service
public class UserService {

	private PasswordEncoder passwordEncoder;	
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		setUserRepository(userRepository);
		this.passwordEncoder = passwordEncoder;
	}

	public User save(User user) {		
		
		if(!isEncodedPassword(user)) {
			user.setPassword(getPasswordEncoder().encode(user.getPassword()));
		}
		
		getUserRepository().save(user);		
		return user;
	}
	
	public boolean isEncodedPassword(User user) {
		
		if(user.getId() == null) {
			return false;
		}		
		User oldUser = getUserRepository().findOne(user.getId());		
		return passwordEncoder.matches(user.getPassword(), oldUser.getPassword());
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	
}
