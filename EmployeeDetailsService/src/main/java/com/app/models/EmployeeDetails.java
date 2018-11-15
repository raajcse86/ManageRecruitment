/**
 * 
 */
package com.app.models;

import java.util.Date;

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
@Document(collection = "EmployeeDetails")
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class EmployeeDetails {

	@Id
	private String id;
	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", email=" + email + ", status=" + status
				+ ", createdAt=" + createdAt + "]";
	}

	@NotBlank
	@Size(max = 100)
	private String name;
	@Indexed(unique = true)
	private String email;

	private String status;

	private Date createdAt = new Date();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
