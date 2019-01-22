/**
 * 
 */
package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.models.CandidatureDetails;
import com.app.models.Chart;
import com.app.models.Reports;

/**
 * @author Rajasekar.Murugesan
 *
 */
public interface CandidatureDetailsService {
	List<CandidatureDetails> findAll();
    CandidatureDetails save(CandidatureDetails CandidatureDetails);
	Optional<CandidatureDetails> getCandidatureDetailsById(String id);
	CandidatureDetails updateCandidatureDetails(String id, CandidatureDetails emp);
	void deleteCandidatureDetails(String id);
	List<CandidatureDetails> updateListOfCandidatureDetails(List<CandidatureDetails> empDetails);
	Chart findCandidatesByCriteria(String criteria);
	List<Reports> findCandidatesReports(String criteria);
	List<CandidatureDetails> findCandidatureDetailsByCategoryCriteriaAndType(String Category,String criteria,String type);

}
