package com.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.models.RegisterDetails;

@Repository
public interface RegisterRepository extends MongoRepository<RegisterDetails, String> {

	public List<RegisterDetails> findByRole(String role);
}
