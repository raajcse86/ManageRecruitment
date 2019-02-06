package com.app.models;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class RegisterDetails {

	@NotBlank
	private String firstName;

	private String lastName;

	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@Id
	@NotBlank
	private String emailId;
	
	private String status;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
