package com.mspandrade.starterproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotBlank
	@Column(unique=true)
	private String username;
	@Column(unique=true)
	private String email;
	@JsonIgnore
	private String password;
	
	public User() {}
	
	public User(String username,String email,String password) {
		setUsername(username);
		setEmail(email);
		setPassword(password);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonSetter("password")
	public void setPassword(String password) {
		this.password = password;
	}
	
}
