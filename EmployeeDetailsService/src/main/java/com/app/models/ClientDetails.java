package com.app.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Madhamanchi Nikhil Chowdary
 *
 */

@Document(collection = "ClientDetails")
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class ClientDetails {

	@Id
	private String id;

	private String clientName;

	private String leadName;

	private String location;

	private String skill;

	private String contractMechanism;

	private String target;
	
	private Date createdDate;
	
	private Date updateDate;
	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getLeadName() {
		return leadName;
	}

	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getContractMechanism() {
		return contractMechanism;
	}

	public void setContractMechanism(String contractMechanism) {
		this.contractMechanism = contractMechanism;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientDetails other = (ClientDetails) obj;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientDetails [id=" + id + ", clientName=" + clientName + ", leadName=" + leadName + ", location="
				+ location + ", skill=" + skill + ", contractMechanism=" + contractMechanism + ", target=" + target
				+ ", createdDate=" + createdDate + ", updateDate=" + updateDate + "]";
	}


}
