package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.models.ClientDetails;
import com.app.models.Summary;

/**
 * @author Madhamanchi Nikhil Chowdary
 *
 */

public interface ClientDetailsService {

	List<ClientDetails> findAll();

	void save(ClientDetails clientDetails);
	
	public void saveAll(List<ClientDetails> clientDetails);

	Optional<ClientDetails> findClientDetailsById(String id);
	
	List<ClientDetails> findAllClients();

	ClientDetails updateClientDetails(String id, ClientDetails clientDetails);

	void deleteClientDetails(String id);

	List<ClientDetails> updateListOfClientDetails(List<ClientDetails> clientDetails);
	
	public List<Summary> getSummaryData();
	

}
