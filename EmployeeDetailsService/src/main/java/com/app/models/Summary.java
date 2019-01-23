package com.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Summary {

	private String clientName;
	private String LeadName;
	private String Location;
	private String skill;
	private String contractMechanism;
	private Integer target;
	private Integer InterviewInProgress;
	private Integer joined;
	private Integer offerInProgress;
	private Integer screeningInProgress;
	private Integer offerReleased;

	public Integer getOfferReleased() {
		return offerReleased;
	}

	public void setOfferReleased(Integer offerReleased) {
		this.offerReleased = offerReleased;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getLeadName() {
		return LeadName;
	}

	public void setLeadName(String leadName) {
		LeadName = leadName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
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

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public Integer getInterviewInProgress() {
		return InterviewInProgress;
	}

	public void setInterviewInProgress(Integer interviewInProgress) {
		InterviewInProgress = interviewInProgress;
	}

	public Integer getJoined() {
		return joined;
	}

	public void setJoined(Integer joined) {
		this.joined = joined;
	}

	public Integer getOfferInProgress() {
		return offerInProgress;
	}

	public void setOfferInProgress(Integer offerInProgress) {
		this.offerInProgress = offerInProgress;
	}

	public Integer getScreeningInProgress() {
		return screeningInProgress;
	}

	public void setScreeningInProgress(Integer screeningInProgress) {
		this.screeningInProgress = screeningInProgress;
	}

}
