package com.app.services;

import com.app.models.RegisterDetails;

public interface SendSMSService {
	
	public String sendSMS(final String subject, final RegisterDetails registerDetails);

}
