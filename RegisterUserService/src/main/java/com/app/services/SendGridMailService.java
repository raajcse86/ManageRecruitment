package com.app.services;

import java.io.IOException;

import com.app.models.RegisterDetails;
import com.sendgrid.Response;

public interface SendGridMailService {

	Response sendEmail(String toAddress, String subject, RegisterDetails registerDetails);
}