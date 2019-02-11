package com.app.services;

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
		return registerRepository.findAll();
	}

	@Override
	public RegisterDetails update(@Valid RegisterDetails registerDetails) {
		Optional<RegisterDetails> user = registerRepository.findById(registerDetails.getEmailId());
		user.get().setStatus(registerDetails.getStatus());
		return registerRepository.save(user.get());
	}

}
