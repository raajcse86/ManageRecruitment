package com.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.RegisterDetails;
import com.app.services.RegisterService;
import com.google.gson.Gson;

@RestController
@CrossOrigin("*")
public class RegisterController {

	@Autowired

	RegisterService registerService;

	@PostMapping("/users/register")
	public void register(@Valid @RequestBody RegisterDetails registerDetails) {
		System.out.println("In register controller :: ");
		System.out.println("Request in api :: "+new Gson().toJson(registerDetails));
		registerService.save(registerDetails);

		System.out.println("SUCCESSFUL");
	}

}
