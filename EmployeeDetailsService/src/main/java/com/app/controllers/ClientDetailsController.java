package com.app.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.ClientDetails;
import com.app.models.ExceptionModel;
import com.app.models.Summary;
import com.app.services.ClientDetailsService;
import com.app.services.InvalidExcelFormatException;
import com.google.gson.Gson;

@RestController
@RequestMapping("/clientDetails")
@CrossOrigin("*")
public class ClientDetailsController {

	@Autowired
	private ClientDetailsService clientDetailsService;

	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody ClientDetails clientDetails) {

		try {
			List<ClientDetails> clientDetails2 = clientDetailsService.save(clientDetails);
			return new ResponseEntity<>(clientDetails2, HttpStatus.CREATED);
		} catch (InvalidExcelFormatException e) {
			ExceptionModel exceptionModel = new ExceptionModel();
			exceptionModel.setCode(401);
			exceptionModel.setMessage(e.getMessage());
			exceptionModel.setStatus("Failed");
			return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			ExceptionModel exceptionModel = new ExceptionModel();
			exceptionModel.setCode(401);
			exceptionModel.setMessage(ex.getMessage());
			exceptionModel.setStatus("Failed");
			return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.BAD_REQUEST);
		}

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

	@DeleteMapping("/deleteClient/{id}")
	public List<ClientDetails> delete(@PathVariable("id") String id) {
		return clientDetailsService.deleteClient(id);
	}

	@PostMapping("/deleteClients")
	public List<ClientDetails> deleteAll(@RequestBody List<ClientDetails> clientDetails) {
		return clientDetailsService.deleteClients(clientDetails);
	}

	@PostMapping("/update")
	public List<ClientDetails> updateClient(@RequestBody ClientDetails clientDetails) {
		return clientDetailsService.updateClientDetails(clientDetails);
	}

	@GetMapping("/getSummaryData")
	public List<Summary> getSummaryData() {

		return clientDetailsService.getSummaryData();

	}

}
