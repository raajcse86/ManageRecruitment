package com.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.models.RegisterDetails;

@Repository
public interface RegisterRepository extends MongoRepository<RegisterDetails, String> {

}
