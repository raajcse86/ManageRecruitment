package com.app.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.models.RegisterDetails;
import com.google.gson.Gson;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class SendGridMailServiceImpl implements SendGridMailService {

	@Autowired
	SendGrid sendGrid;

	@Value("${spring.sendgrid.api-key}")
	private String apikey;

	@Value("${spring.sendgrid.from}")
	private String fromAddress;
	
	@Value("${application.login.url}")
	private String loginURL;

	private static final String REGISTRATION = "Registration successfull";
	private static final String APPROVAL_REQUEST = "Registration request for approval";
	private static final String APPROVED = "Registration request approved";
	private static final String REJECTED = "Registration request rejected";
	private static final String ROLE_ADMIN="ROLE_ADMIN";
	

	@Override
	public Response sendEmail(final String toAddress,final String subject, final RegisterDetails registerDetails){
		 	Email from = new Email(fromAddress);
		    Email to = new Email(toAddress);
		    System.out.println("TO address is "+toAddress+" Subject is "+subject);
		    String message = constructBody(subject, registerDetails);
		    Content content = new Content("text/html", message);
		    Mail mail = new Mail(from, subject, to, content);
		    Request request = new Request();
		    Response response = null;
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      response = sendGrid.api(request);
		    } catch (IOException ex) {
		     ex.printStackTrace();
		    }
			return response;
	    }

	public String constructBody(String subject, final RegisterDetails details) {
		StringBuilder mailBody = new StringBuilder();
		switch (subject) {
		case REGISTRATION:
			mailBody.append("<i>Registration Successfull!</i><br>");
			mailBody.append("<b>Registration is successfull and pending for admin approval. Once approved by admin, you will "
					+ "recieve the confirmation email with link to login</b><br>");
		    mailBody.append("<font color=yellogreen>your username is "+details.getUsername()+"</font>");
			break;
		case APPROVAL_REQUEST:
			mailBody.append("<i>Registration Approval pending</i><br>");
			mailBody.append("<b>Registration request is pending for approval for user "+details.getEmailId()
					+" Please login to HR Application to view all the registration requests pending for approval</b><br>");
		    mailBody.append("<font color=blue><a href="+loginURL+">Login now </a></font>");
			break;
		case APPROVED:
			String userType=null;
			if(ROLE_ADMIN.contentEquals(details.getRole()))
					userType="Admin";
			else 
					userType="Normal User";
			
			mailBody.append("<i>Registration request is approved</i><br>");
			mailBody.append("<b>Your request is approved as "+userType+", Click on below link to login with username "+details.getUsername()+"</b><br>");
		    mailBody.append("<font color=blue><a href="+loginURL+">Login now </a></font>");
			break;
		case REJECTED:
			mailBody.append("<i>Registration request is Rejected</i><br>");
			mailBody.append("<b>Your request is Rejected. Admin comments are: "+details.getComments()+"</b><br>");
		    mailBody.append("<font color=blue> Register again with all the valid details</font>");
			break;

		default:
			break;
		}
		return mailBody.toString();
	}
}
