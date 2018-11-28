/**
 * 
 */
package com.app.models;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
	private String positionLocation;
	private String candidateName;
	private String contactNo;
	private String emailId;
	private String totalExperience;
	private String relevantExperience;
	private String NoticePeriod;
	private String currentLocation;
	private String preferredLocation;
	private String modeOfHiring;
	private String vendorName;
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
	private String candidatureStatus;
	private String offerRollOutDate;
	private String joiningDate;
	private String joiningStatus;
	private String nhrId;
	private String comments;
	private String action;
	private String client;
	private String profile;
	private String lastUpdateDate;
	
	/**
	 * @return the roleOfResponsibilities
	 */
	public String getRoleOfResponsibilities() {
		return roleOfResponsibilities;
	}
	/**
	 * @param roleOfResponsibilities the roleOfResponsibilities to set
	 */
	public void setRoleOfResponsibilities(String roleOfResponsibilities) {
		this.roleOfResponsibilities = roleOfResponsibilities;
	}
	/**
	 * @return the positionLocation
	 */
	public String getPositionLocation() {
		return positionLocation;
	}
	/**
	 * @param positionLocation the positionLocation to set
	 */
	public void setPositionLocation(String positionLocation) {
		this.positionLocation = positionLocation;
	}
	/**
	 * @return the candidateName
	 */
	public String getCandidateName() {
		return candidateName;
	}
	/**
	 * @param candidateName the candidateName to set
	 */
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the totalExperience
	 */
	public String getTotalExperience() {
		return totalExperience;
	}
	/**
	 * @param totalExperience the totalExperience to set
	 */
	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}
	/**
	 * @return the relevantExperience
	 */
	public String getRelevantExperience() {
		return relevantExperience;
	}
	/**
	 * @param relevantExperience the relevantExperience to set
	 */
	public void setRelevantExperience(String relevantExperience) {
		this.relevantExperience = relevantExperience;
	}
	/**
	 * @return the noticePeriod
	 */
	public String getNoticePeriod() {
		return NoticePeriod;
	}
	/**
	 * @param noticePeriod the noticePeriod to set
	 */
	public void setNoticePeriod(String noticePeriod) {
		NoticePeriod = noticePeriod;
	}
	/**
	 * @return the currentLocation
	 */
	public String getCurrentLocation() {
		return currentLocation;
	}
	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	/**
	 * @return the preferredLocation
	 */
	public String getPreferredLocation() {
		return preferredLocation;
	}
	/**
	 * @param preferredLocation the preferredLocation to set
	 */
	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}
	/**
	 * @return the modeOfHiring
	 */
	public String getModeOfHiring() {
		return modeOfHiring;
	}
	/**
	 * @param modeOfHiring the modeOfHiring to set
	 */
	public void setModeOfHiring(String modeOfHiring) {
		this.modeOfHiring = modeOfHiring;
	}
	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}
	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	/**
	 * @return the profileSharedDate
	 */
	public String getProfileSharedDate() {
		return profileSharedDate;
	}
	/**
	 * @param profileSharedDate the profileSharedDate to set
	 */
	public void setProfileSharedDate(String profileSharedDate) {
		this.profileSharedDate = profileSharedDate;
	}
	/**
	 * @return the screeningStatus
	 */
	public String getScreeningStatus() {
		return screeningStatus;
	}
	/**
	 * @param screeningStatus the screeningStatus to set
	 */
	public void setScreeningStatus(String screeningStatus) {
		this.screeningStatus = screeningStatus;
	}
	/**
	 * @return the screeningDate
	 */
	public String getScreeningDate() {
		return screeningDate;
	}
	/**
	 * @param screeningDate the screeningDate to set
	 */
	public void setScreeningDate(String screeningDate) {
		this.screeningDate = screeningDate;
	}
	/**
	 * @return the screeningDoneBy
	 */
	public String getScreeningDoneBy() {
		return screeningDoneBy;
	}
	/**
	 * @param screeningDoneBy the screeningDoneBy to set
	 */
	public void setScreeningDoneBy(String screeningDoneBy) {
		this.screeningDoneBy = screeningDoneBy;
	}
	/**
	 * @return the firstRoundStatus
	 */
	public String getFirstRoundStatus() {
		return firstRoundStatus;
	}
	/**
	 * @param firstRoundStatus the firstRoundStatus to set
	 */
	public void setFirstRoundStatus(String firstRoundStatus) {
		this.firstRoundStatus = firstRoundStatus;
	}
	/**
	 * @return the firstRoundDate
	 */
	public String getFirstRoundDate() {
		return firstRoundDate;
	}
	/**
	 * @param firstRoundDate the firstRoundDate to set
	 */
	public void setFirstRoundDate(String firstRoundDate) {
		this.firstRoundDate = firstRoundDate;
	}
	/**
	 * @return the firstRoundTakenBy
	 */
	public String getFirstRoundTakenBy() {
		return firstRoundTakenBy;
	}
	/**
	 * @param firstRoundTakenBy the firstRoundTakenBy to set
	 */
	public void setFirstRoundTakenBy(String firstRoundTakenBy) {
		this.firstRoundTakenBy = firstRoundTakenBy;
	}
	/**
	 * @return the secondRoundStatus
	 */
	public String getSecondRoundStatus() {
		return secondRoundStatus;
	}
	/**
	 * @param secondRoundStatus the secondRoundStatus to set
	 */
	public void setSecondRoundStatus(String secondRoundStatus) {
		this.secondRoundStatus = secondRoundStatus;
	}
	/**
	 * @return the secondRoundDate
	 */
	public String getSecondRoundDate() {
		return secondRoundDate;
	}
	/**
	 * @param secondRoundDate the secondRoundDate to set
	 */
	public void setSecondRoundDate(String secondRoundDate) {
		this.secondRoundDate = secondRoundDate;
	}
	/**
	 * @return the secondRoundTakenBy
	 */
	public String getSecondRoundTakenBy() {
		return secondRoundTakenBy;
	}
	/**
	 * @param secondRoundTakenBy the secondRoundTakenBy to set
	 */
	public void setSecondRoundTakenBy(String secondRoundTakenBy) {
		this.secondRoundTakenBy = secondRoundTakenBy;
	}
	/**
	 * @return the finalRoundStatus
	 */
	public String getFinalRoundStatus() {
		return finalRoundStatus;
	}
	/**
	 * @param finalRoundStatus the finalRoundStatus to set
	 */
	public void setFinalRoundStatus(String finalRoundStatus) {
		this.finalRoundStatus = finalRoundStatus;
	}
	/**
	 * @return the finalRoundDate
	 */
	public String getFinalRoundDate() {
		return finalRoundDate;
	}
	/**
	 * @param finalRoundDate the finalRoundDate to set
	 */
	public void setFinalRoundDate(String finalRoundDate) {
		this.finalRoundDate = finalRoundDate;
	}
	/**
	 * @return the finalRoundTakenBy
	 */
	public String getFinalRoundTakenBy() {
		return finalRoundTakenBy;
	}
	/**
	 * @param finalRoundTakenBy the finalRoundTakenBy to set
	 */
	public void setFinalRoundTakenBy(String finalRoundTakenBy) {
		this.finalRoundTakenBy = finalRoundTakenBy;
	}
	/**
	 * @return the hrOrPnStageRound
	 */
	public String getHrOrPnStageRound() {
		return hrOrPnStageRound;
	}
	/**
	 * @param hrOrPnStageRound the hrOrPnStageRound to set
	 */
	public void setHrOrPnStageRound(String hrOrPnStageRound) {
		this.hrOrPnStageRound = hrOrPnStageRound;
	}
	/**
	 * @return the hrOrPnStageStatus
	 */
	public String getHrOrPnStageStatus() {
		return hrOrPnStageStatus;
	}
	/**
	 * @param hrOrPnStageStatus the hrOrPnStageStatus to set
	 */
	public void setHrOrPnStageStatus(String hrOrPnStageStatus) {
		this.hrOrPnStageStatus = hrOrPnStageStatus;
	}
	/**
	 * @return the hrOrPnStageDate
	 */
	public String getHrOrPnStageDate() {
		return hrOrPnStageDate;
	}
	/**
	 * @param hrOrPnStageDate the hrOrPnStageDate to set
	 */
	public void setHrOrPnStageDate(String hrOrPnStageDate) {
		this.hrOrPnStageDate = hrOrPnStageDate;
	}
	/**
	 * @return the candidatureStatus
	 */
	public String getCandidatureStatus() {
		return candidatureStatus;
	}
	/**
	 * @param candidatureStatus the candidatureStatus to set
	 */
	public void setCandidatureStatus(String candidatureStatus) {
		this.candidatureStatus = candidatureStatus;
	}
	/**
	 * @return the offerRollOutDate
	 */
	public String getOfferRollOutDate() {
		return offerRollOutDate;
	}
	/**
	 * @param offerRollOutDate the offerRollOutDate to set
	 */
	public void setOfferRollOutDate(String offerRollOutDate) {
		this.offerRollOutDate = offerRollOutDate;
	}
	/**
	 * @return the joiningDate
	 */
	public String getJoiningDate() {
		return joiningDate;
	}
	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	/**
	 * @return the joiningStatus
	 */
	public String getJoiningStatus() {
		return joiningStatus;
	}
	/**
	 * @param joiningStatus the joiningStatus to set
	 */
	public void setJoiningStatus(String joiningStatus) {
		this.joiningStatus = joiningStatus;
	}
	/**
	 * @return the nhrId
	 */
	public String getNhrId() {
		return nhrId;
	}
	/**
	 * @param nhrId the nhrId to set
	 */
	public void setNhrId(String nhrId) {
		this.nhrId = nhrId;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/**
	 * @return the lastUpdateDate
	 */
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
}
