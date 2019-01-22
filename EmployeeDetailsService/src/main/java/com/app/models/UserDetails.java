/**
 * 
 */
package com.app.models;

import java.util.Collection;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Rajasekar.Murugesan
 *
 */

@Document(collection = "User")
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class UserDetails {
	

	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	@Id
	private String id;

	@NotBlank
	@Size(max = 100)
	@Indexed(unique=true)
	private String username;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	private String password;
	
	
	
	
	private String role;

	

}
