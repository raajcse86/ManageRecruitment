package com.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.models.ClientDetails;

/**
 * @author Madhamanchi Nikhil Chowdary
 *
 */

public interface ClientDetailsRepository extends MongoRepository<ClientDetails, String>{
	
	public List<ClientDetails> findByClientName(String name);

}
