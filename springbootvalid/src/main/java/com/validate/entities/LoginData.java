package com.validate.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData {

	@NotBlank(message = "Username cannot be blank")
	@Size(min = 3, max = 10, message = "Username must be between 3 and 10 characters")
	private String userName;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5,}$", message = "Password must be 5 or more characters")
	private String email;
    
	@AssertTrue	
	private boolean rememberMe;
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}
}
