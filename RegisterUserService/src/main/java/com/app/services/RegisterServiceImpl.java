package com.app.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.app.models.RegisterDetails;
import com.app.repositories.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	RegisterRepository registerRepository;

	@Autowired
	SendGridMailService sendGridMailService;

	private static final String REGISTRATION = "Registration successfull";
	private static final String APPROVAL_REQUEST = "Registration request for approval";
	private static final String APPROVED = "Registration request approved";
	private static final String REJECTED = "Registration request rejected";
	private static final String DEFAULT_ROLE = "ROLE_USER";
	private static final String ADMIN_ROLE = "ROLE_ADMIN";

	@Override
	public void save(RegisterDetails registerDetails) {
		registerDetails.setPassword(new Base64().encodeBase64String(registerDetails.getPassword().getBytes()));
		if (null == registerDetails.getStatus())
			registerDetails.setStatus("Pending for approval");
		registerDetails.setRole(DEFAULT_ROLE);
		RegisterDetails savedUser = registerRepository.save(registerDetails);
		if (null != savedUser) {
			new Thread(() -> {
				sendGridMailService.sendEmail(savedUser.getEmailId(), REGISTRATION, savedUser);
			}).start();

			new Thread(() -> {
				List<RegisterDetails> admins = registerRepository.findByRole(ADMIN_ROLE);
				if (null != admins)
					admins.forEach(admin -> {
						sendGridMailService.sendEmail(admin.getEmailId(), APPROVAL_REQUEST, savedUser);
					});

			}).start();
		}
	}

	@Override
	public List<RegisterDetails> findAll() {
		List<RegisterDetails> usersList = registerRepository.findAll();
		Collections.sort(usersList);
		return usersList;
	}

	@Override
	public RegisterDetails update(@Valid RegisterDetails registerDetails) {
		Optional<RegisterDetails> user = registerRepository.findById(registerDetails.getEmailId());
		if (user.isPresent()) {
			final RegisterDetails updatedUser = registerRepository.save(registerDetails);
			if (null != updatedUser) {
				if("Approved".contentEquals(updatedUser.getStatus())) {
				new Thread(() -> {
						sendGridMailService.sendEmail(updatedUser.getEmailId(), APPROVED, updatedUser);
					
				}).start();
				
				}else if ("Rejected".contentEquals(updatedUser.getStatus())) {
					new Thread(() -> {
						sendGridMailService.sendEmail(updatedUser.getEmailId(), REJECTED, updatedUser);
				}).start();
				}
			}
			return updatedUser;
		}
		return null;
	}

}
