package com.app.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.RegisterDetails;
import com.app.repositories.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	RegisterRepository registerRepository;

	@Override
	public void save(RegisterDetails registerDetails) {
		registerDetails.setPassword(new Base64().encodeBase64String(registerDetails.getPassword().getBytes()));
		if (null == registerDetails.getStatus())
			registerDetails.setStatus("Pending for approval");
		registerRepository.save(registerDetails);
	}

	@Override
	public List<RegisterDetails> findAll() {
		List<RegisterDetails> usersList = registerRepository.findAll();
		Collections.sort(usersList);
		/*
		 * Collections.sort(usersList, (user1, user2) -> { System.out.println(user1.y);
		 * if(user1.getStatus()!="Pending for approval") return 1; else return 0; });
		 */
		return usersList;
	}

	@Override
	public RegisterDetails update(@Valid RegisterDetails registerDetails) {
		Optional<RegisterDetails> user = registerRepository.findById(registerDetails.getEmailId());
		user.get().setStatus(registerDetails.getStatus());
		user.get().setApprover(registerDetails.getApprover());
		user.get().setComments(registerDetails.getComments());
		return registerRepository.save(user.get());
	}

}
