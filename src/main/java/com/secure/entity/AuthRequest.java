package com.secure.entity;

public class AuthRequest {
	private String username;
	private String Password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public AuthRequest(String username, String password) {
		super();
		this.username = username;
		this.Password = password;
	}


}
