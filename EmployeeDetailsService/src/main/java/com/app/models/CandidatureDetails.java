/**
 * 
 */
package com.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Rajasekar.Murugesan
 *
 */
@Document(collection = "CandidatureDetails")
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class CandidatureDetails {

	@Id
	private String id;
	private String roleOfResponsibilities;
	private String candidateName;
	private String contactNo;
	private String emailId;
	private String totalExperience;
	private String relevantExperience;
	private String noticePeriod;
	private String ctc;
	private String expectedCTC;
	private String currentLocation;
	private String preferredLocation;
	private String positionLocation;
	private String modeOfHiring;
	private String source;
	private String profileSharedDate;
	private String screeningStatus;	
	private String screeningDate;	
	private String screeningDoneBy;
	private String firstRoundStatus;
	private String firstRoundDate;
	private String firstRoundTakenBy;
	private String secondRoundStatus;
	private String secondRoundDate;
	private String secondRoundTakenBy;
	private String finalRoundStatus;
	private String finalRoundDate;
	private String finalRoundTakenBy;
	private String hrOrPnStageRound;
	private String hrOrPnStageStatus;
	private String hrOrPnStageDate;
	private String finalStatus;
	private String status;	
	private String description;
	private String actionPending;
	private String client;
	private String profileStatus;
	private String statusUpdatedDate;
	private String expectedJoiningDate;
	public String getId() {
		return id;
	}
	public String getRoleOfResponsibilities() {
		return roleOfResponsibilities;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getTotalExperience() {
		return totalExperience;
	}
	public String getRelevantExperience() {
		return relevantExperience;
	}
	public String getNoticePeriod() {
		return noticePeriod;
	}
	public String getCtc() {
		return ctc;
	}
	public String getExpectedCTC() {
		return expectedCTC;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public String getPreferredLocation() {
		return preferredLocation;
	}
	public String getPositionLocation() {
		return positionLocation;
	}
	public String getModeOfHiring() {
		return modeOfHiring;
	}
	public String getSource() {
		return source;
	}
	public String getProfileSharedDate() {
		return profileSharedDate;
	}
	public String getScreeningStatus() {
		return screeningStatus;
	}
	public String getScreeningDate() {
		return screeningDate;
	}
	public String getScreeningDoneBy() {
		return screeningDoneBy;
	}
	public String getFirstRoundStatus() {
		return firstRoundStatus;
	}
	public String getFirstRoundDate() {
		return firstRoundDate;
	}
	public String getFirstRoundTakenBy() {
		return firstRoundTakenBy;
	}
	public String getSecondRoundStatus() {
		return secondRoundStatus;
	}
	public String getSecondRoundDate() {
		return secondRoundDate;
	}
	public String getSecondRoundTakenBy() {
		return secondRoundTakenBy;
	}
	public String getFinalRoundStatus() {
		return finalRoundStatus;
	}
	public String getFinalRoundDate() {
		return finalRoundDate;
	}
	public String getFinalRoundTakenBy() {
		return finalRoundTakenBy;
	}
	public String getHrOrPnStageRound() {
		return hrOrPnStageRound;
	}
	public String getHrOrPnStageStatus() {
		return hrOrPnStageStatus;
	}
	public String getHrOrPnStageDate() {
		return hrOrPnStageDate;
	}
	public String getFinalStatus() {
		return finalStatus;
	}
	public String getStatus() {
		return status;
	}
	public String getDescription() {
		return description;
	}
	public String getActionPending() {
		return actionPending;
	}
	public String getClient() {
		return client;
	}
	public String getProfileStatus() {
		return profileStatus;
	}
	public String getStatusUpdatedDate() {
		return statusUpdatedDate;
	}
	public String getExpectedJoiningDate() {
		return expectedJoiningDate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setRoleOfResponsibilities(String roleOfResponsibilities) {
		this.roleOfResponsibilities = roleOfResponsibilities;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}
	public void setRelevantExperience(String relevantExperience) {
		this.relevantExperience = relevantExperience;
	}
	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public void setExpectedCTC(String expectedCTC) {
		this.expectedCTC = expectedCTC;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}
	public void setPositionLocation(String positionLocation) {
		this.positionLocation = positionLocation;
	}
	public void setModeOfHiring(String modeOfHiring) {
		this.modeOfHiring = modeOfHiring;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setProfileSharedDate(String profileSharedDate) {
		this.profileSharedDate = profileSharedDate;
	}
	public void setScreeningStatus(String screeningStatus) {
		this.screeningStatus = screeningStatus;
	}
	public void setScreeningDate(String screeningDate) {
		this.screeningDate = screeningDate;
	}
	public void setScreeningDoneBy(String screeningDoneBy) {
		this.screeningDoneBy = screeningDoneBy;
	}
	public void setFirstRoundStatus(String firstRoundStatus) {
		this.firstRoundStatus = firstRoundStatus;
	}
	public void setFirstRoundDate(String firstRoundDate) {
		this.firstRoundDate = firstRoundDate;
	}
	public void setFirstRoundTakenBy(String firstRoundTakenBy) {
		this.firstRoundTakenBy = firstRoundTakenBy;
	}
	public void setSecondRoundStatus(String secondRoundStatus) {
		this.secondRoundStatus = secondRoundStatus;
	}
	public void setSecondRoundDate(String secondRoundDate) {
		this.secondRoundDate = secondRoundDate;
	}
	public void setSecondRoundTakenBy(String secondRoundTakenBy) {
		this.secondRoundTakenBy = secondRoundTakenBy;
	}
	public void setFinalRoundStatus(String finalRoundStatus) {
		this.finalRoundStatus = finalRoundStatus;
	}
	public void setFinalRoundDate(String finalRoundDate) {
		this.finalRoundDate = finalRoundDate;
	}
	public void setFinalRoundTakenBy(String finalRoundTakenBy) {
		this.finalRoundTakenBy = finalRoundTakenBy;
	}
	public void setHrOrPnStageRound(String hrOrPnStageRound) {
		this.hrOrPnStageRound = hrOrPnStageRound;
	}
	public void setHrOrPnStageStatus(String hrOrPnStageStatus) {
		this.hrOrPnStageStatus = hrOrPnStageStatus;
	}
	public void setHrOrPnStageDate(String hrOrPnStageDate) {
		this.hrOrPnStageDate = hrOrPnStageDate;
	}
	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setActionPending(String actionPending) {
		this.actionPending = actionPending;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public void setProfileStatus(String profileStatus) {
		this.profileStatus = profileStatus;
	}
	public void setStatusUpdatedDate(String statusUpdatedDate) {
		this.statusUpdatedDate = statusUpdatedDate;
	}
	public void setExpectedJoiningDate(String expectedJoiningDate) {
		this.expectedJoiningDate = expectedJoiningDate;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidatureDetails other = (CandidatureDetails) obj;
		if (candidateName == null && emailId ==null) {
			if (other.candidateName != null && other.emailId!=null)
				return false;
		} else if (!candidateName.equals(other.candidateName) && !emailId.equals(other.emailId))
			return false;
		return true;
	}
	
	
}
