/**
 * 
 */
package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.CandidatureDetails;
import com.app.repositories.CandidatureDetailsRepository;

/**
 * @author Rajasekar.Murugesan
 *
 */
@Service
public class CandidatureDetailsServiceImpl implements CandidatureDetailsService {

	@Autowired
	private CandidatureDetailsRepository candidatureDetailsRepository;
	
	@Override
	public List<CandidatureDetails> findAll() {
		return candidatureDetailsRepository.findAll();
	}

	@Override
	public CandidatureDetails save(CandidatureDetails CandidatureDetails) {
		return candidatureDetailsRepository.save(CandidatureDetails);
	}

	@Override
	public Optional<CandidatureDetails> getCandidatureDetailsById(String id) {
		return candidatureDetailsRepository.findById(id);
               
	}

	@Override
	public CandidatureDetails updateCandidatureDetails(String id, CandidatureDetails empDetails) {
		Optional<CandidatureDetails> emp = candidatureDetailsRepository.findById(id);
		CandidatureDetails details = emp.get();
		//details.setName(empDetails.getName());
		//details.setEmail(empDetails.getEmail());
		//details.setStatus(empDetails.getStatus());
		return candidatureDetailsRepository.save(details);
		
	}
	
	@Override
	public List<CandidatureDetails> updateListOfCandidatureDetails(List<CandidatureDetails> empDetailsFrmExternalSystem) {
		List<CandidatureDetails> empListFrmDb = candidatureDetailsRepository.findAll();
		for(CandidatureDetails empFrmDb: empListFrmDb) {
			for(CandidatureDetails empFrmSys:empDetailsFrmExternalSystem) {
				if(empFrmSys.equals(empFrmDb)) {
					candidatureDetailsRepository.delete(empFrmDb);
				}
			}
		}
		return candidatureDetailsRepository.saveAll(empDetailsFrmExternalSystem);
	}
	
	
	

	@Override
	public void deleteCandidatureDetails(String id) {
		candidatureDetailsRepository.deleteById(id);
	}

}
