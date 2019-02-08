package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.RegisterDetails;
import com.app.services.RegisterService;
import com.google.gson.Gson;

@RestController
@RefreshScope
@CrossOrigin("*")
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@Value("${msg:Hello world - Config Server is not working..pelase check}")
	private String msg;

	@RequestMapping("/msg")
	String getMsg() {
		return this.msg;
	}
	
	@PostMapping("/users/register")
	public void register(@Valid @RequestBody RegisterDetails registerDetails) {
		registerService.save(registerDetails);
	}

	@GetMapping("/users")
	public ResponseEntity<List<RegisterDetails>> getAllRegisteredUsers() {
		List<RegisterDetails> usersList = registerService.findAll();
		ResponseEntity<List<RegisterDetails>> response = null;
		if (null != usersList && !usersList.isEmpty()) {
			response = new ResponseEntity<List<RegisterDetails>>(usersList, HttpStatus.OK);
		} else {
			response = new ResponseEntity<List<RegisterDetails>>(usersList, HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@PutMapping("/users/update")
	public ResponseEntity<RegisterDetails> updateStatus(@Valid @RequestBody RegisterDetails registerDetails) {
		RegisterDetails registeredUser = registerService.update(registerDetails);
		ResponseEntity<RegisterDetails> response = new ResponseEntity<RegisterDetails>(registeredUser, HttpStatus.OK);
		return response;
	}

}
