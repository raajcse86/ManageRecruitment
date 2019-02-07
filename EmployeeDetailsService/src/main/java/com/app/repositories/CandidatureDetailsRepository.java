/**
 * 
 */
package com.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.models.CandidatureDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
@Repository
public interface CandidatureDetailsRepository extends MongoRepository<CandidatureDetails, String> {
	
	public List<CandidatureDetails> findByClient(String name);
	
	public List<CandidatureDetails> findByCandidateNameAndEmailId(String candidateName, String emailId);

}
