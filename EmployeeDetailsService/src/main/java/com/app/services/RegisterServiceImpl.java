package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.models.RegisterDetails;
import com.app.repositories.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService{
		@Autowired
		RegisterRepository registerRepository;

		@Override
		public void save(RegisterDetails registerDetails) {
			registerDetails.setPassword(new BCryptPasswordEncoder().encode(registerDetails.getPassword()));
			if(null==registerDetails.getStatus())
				registerDetails.setStatus("Approval Pending");
			registerRepository.save(registerDetails);		
		}

	}


