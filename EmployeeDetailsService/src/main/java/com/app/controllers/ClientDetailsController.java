package com.app.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.ClientDetails;
import com.app.models.Summary;
import com.app.services.ClientDetailsService;

@RestController
@RequestMapping("/clientDetails")
@CrossOrigin("*")
public class ClientDetailsController {

	@Autowired
	private ClientDetailsService clientDetailsService;

	@PostMapping("/save")
	public void save(@Valid @RequestBody ClientDetails clientDetails) {
		clientDetailsService.save(clientDetails);
	}

	@PostMapping("/saveAll")
	public void saveAll(List<ClientDetails> clientDetails) {
		clientDetailsService.saveAll(clientDetails);
	}

	@GetMapping("/findById/{id}")
	public Optional<ClientDetails> findById(@PathVariable("id") String id) {

		return clientDetailsService.findClientDetailsById(id);

	}

	@GetMapping("/findAll")
	public List<ClientDetails> findAll() {
		return clientDetailsService.findAll();
	}
	
	@GetMapping("/getSummaryData")
	public List<Summary> getSummaryData(){
		
		return clientDetailsService.getSummaryData();
		
	}
	

}
