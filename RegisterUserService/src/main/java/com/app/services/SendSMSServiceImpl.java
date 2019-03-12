package com.app.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.models.RegisterDetails;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SendSMSServiceImpl implements SendSMSService {

//	final String[] strContacts = { "+917780640164", "+919479774632" };

	@Value("${twilio.sms.sid}")
	private String ACCOUNT_SID;

	@Value("${twilio.sms.apikey}")
	private String AUTH_TOKEN;

	@Value("${twilio.sms.number}")
	private String NUMBER;

	@Value("${twilio.sms.tocontacts}")
	private String tocontacts;

	private static final String APPROVED = "Registration request approved";
	private static final String REJECTED = "Registration request rejected";
	private static final String ROLE_ADMIN = "ROLE_ADMIN";

	@Override
	public String sendSMS(String subject, RegisterDetails registerDetails) {
		String res = "";
		StringBuilder content = new StringBuilder();
		String[] strContacts = tocontacts.split(",");

		switch (subject) {
		case APPROVED:
			String userType = null;
			if (ROLE_ADMIN.contentEquals(registerDetails.getRole()))
				userType = "Admin";
			else
				userType = "Normal User";

			content.append("Nivedita Approved Registration request of " + registerDetails.getFirstName() + " with "
					+ userType + " privilleges");
			break;
		case REJECTED:
			content.append("Nivedita Rejected Registration request of " + registerDetails.getFirstName() + " ");
			break;

		}
		for (int i = 0; i < strContacts.length; i++) {
			Message message = this.send(strContacts[i], content.toString());
			res = message.getStatus().toString();
			System.out.println("Result after sending message :: " + res);

		}

		return res;
	}

	public Message send(String contact, String content) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(new PhoneNumber(contact), new PhoneNumber(NUMBER), content).create();
		System.out.println("SMS sent to :: " + contact);

		return message;
	}

}
