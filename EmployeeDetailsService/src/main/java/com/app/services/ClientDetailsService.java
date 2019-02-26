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

	 List<ClientDetails> save(ClientDetails clientDetails) throws InvalidExcelFormatException;

	public void saveAll(List<ClientDetails> clientDetails);

	Optional<ClientDetails> findClientDetailsById(String id);

	List<ClientDetails> findAllClients();

	List<ClientDetails> updateClientDetails(ClientDetails clientDetails);

	List<ClientDetails> deleteClient(String id);

	List<ClientDetails> deleteClients(List<ClientDetails> clientDetails);

	List<ClientDetails> updateListOfClientDetails(List<ClientDetails> clientDetails);

	public List<Summary> getSummaryData();

}
