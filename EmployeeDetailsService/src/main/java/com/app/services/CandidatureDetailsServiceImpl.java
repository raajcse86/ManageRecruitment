/**
 * 
 */
package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.CandidatureDetails;
import com.app.models.Chart;
import com.app.models.ChartDataSet;
import com.app.models.Data;
import com.app.models.Reports;
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
	public Chart findCandidatesByCriteria(String criteria) {
		List<CandidatureDetails> allCandidateDetails = getAllCandidateDetails();
		Map<String, Map<String, List<CandidatureDetails>>> candidatesByCityandCriteria = null;
		if(criteria.equalsIgnoreCase("location"))
		candidatesByCityandCriteria = allCandidateDetails.stream()
				.collect(Collectors.groupingBy(CandidatureDetails::getPositionLocation,
						Collectors.groupingBy(CandidatureDetails::getFinalStatus)));
		else if(criteria.equalsIgnoreCase("client"))
				candidatesByCityandCriteria = allCandidateDetails.stream()
						.collect(Collectors.groupingBy(CandidatureDetails::getClient,
								Collectors.groupingBy(CandidatureDetails::getFinalStatus)));
		else
			candidatesByCityandCriteria = allCandidateDetails.stream()
			.collect(Collectors.groupingBy(CandidatureDetails::getRoleOfResponsibilities,
					Collectors.groupingBy(CandidatureDetails::getFinalStatus)));
		Chart chart = new Chart();
		List<String> chartLabels = new ArrayList<String>();
		chartLabels.add("Interviews in Progress");
		chartLabels.add("Joined");
		chartLabels.add("Offer in Progress");
		chartLabels.add("On hold");
		chartLabels.add("Rejected/Not shortlisted");
		chartLabels.add("Screening in Progress");
		chart.setChartLabels(chartLabels);
		List<ChartDataSet> chartDataSet = new ArrayList<ChartDataSet>();
		for(Map.Entry<String, Map<String, List<CandidatureDetails>>> superMap : candidatesByCityandCriteria.entrySet())
		{
			ChartDataSet dataset = new ChartDataSet();
			dataset.setLabel(superMap.getKey());
			Map<String, List<CandidatureDetails>> valueDataset = new TreeMap<String, List<CandidatureDetails>>(superMap.getValue());
			List<Integer> selectionList = new ArrayList<Integer>();
			if (null!=valueDataset.get("Interviews in Progress") && valueDataset.get("Interviews in Progress").size() > 0)
				selectionList.add(valueDataset.get("Interviews in Progress").size());
			    
			else
				selectionList.add(0);
			if (null!=valueDataset.get("Joined") && valueDataset.get("Joined").size() > 0)
				selectionList.add(valueDataset.get("Joined").size());
			else
				selectionList.add(0);
			if (null!=valueDataset.get("Offer in Progress") && valueDataset.get("Offer in Progress").size() > 0)
				selectionList.add(valueDataset.get("Offer in Progress").size());
			else
				selectionList.add(0);
			if (null!=valueDataset.get("On hold") && valueDataset.get("On hold").size() > 0)
				selectionList.add(valueDataset.get("On hold").size());
			else
				selectionList.add(0);
			if (null!=valueDataset.get("Rejected/Not shortlisted") && valueDataset.get("Rejected/Not shortlisted").size() > 0)
				selectionList.add(valueDataset.get("Rejected/Not shortlisted").size());
			else
				selectionList.add(0);
			if (null!=valueDataset.get("Screening in Progress") && valueDataset.get("Screening in Progress").size() > 0)
				selectionList.add(valueDataset.get("Screening in Progress").size());
			else
				selectionList.add(0);
			dataset.setData(selectionList);
			chartDataSet.add(dataset);
				
				
			}
		chart.setChartDatasets(chartDataSet);
		return chart;
			
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
		List<CandidatureDetails> empListFrmDb = getAllCandidateDetails();
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

	@Override
	public List<CandidatureDetails> findCandidatureDetailsByCategoryCriteriaAndType(String criteria, String category,
			String type) {
		// TODO Auto-generated method stub
		if (type.equalsIgnoreCase("IntInProg"))
			type = "Interviews in Progress";
		else if (type.equalsIgnoreCase("Joined"))
			type = "Joined";
		else if (type.equalsIgnoreCase("OffInProg"))
			type = "Offer in Progress";
		else if (type.equalsIgnoreCase("ONHold"))
			type = "On hold";
		else if (type.equalsIgnoreCase("Rejected"))
			type = "Rejected/Not shortlisted";
		else
			type = "Screening in Progress";
		return getFilterValues(criteria,category,type);
		
	}
	
	public List<CandidatureDetails> getFilterValues(String criteria, String category,String type)
	{
		List<CandidatureDetails> refineCandidateDetails = null;
		List<CandidatureDetails> allCandidateDetails = getAllCandidateDetails();
		if(criteria.equalsIgnoreCase("location"))
			refineCandidateDetails = allCandidateDetails.stream()
					.filter(Candidates -> Candidates.getPositionLocation().equalsIgnoreCase(category)
							&& Candidates.getFinalStatus().equalsIgnoreCase(type))
					.collect(Collectors.toList());
			else if(criteria.equalsIgnoreCase("client"))
				refineCandidateDetails = allCandidateDetails.stream()
				.filter(Candidates -> Candidates.getClient().equalsIgnoreCase(category)
						&& Candidates.getFinalStatus().equalsIgnoreCase(type))
				.collect(Collectors.toList());
			else
				refineCandidateDetails = allCandidateDetails.stream()
				.filter(Candidates -> Candidates.getRoleOfResponsibilities().equalsIgnoreCase(category)
						&& Candidates.getFinalStatus().equalsIgnoreCase(type))
				.collect(Collectors.toList());
		return refineCandidateDetails;
		
	}
	
	private List<CandidatureDetails> getAllCandidateDetails()
	{
		return candidatureDetailsRepository.findAll();
	}

	@Override
	public List<Reports> findCandidatesReports(String criteria) {
		List<CandidatureDetails> allCandidateDetails = getAllCandidateDetails();
		List<Reports> finalReports = new ArrayList<Reports>();
		List<Reports> statusReports = new ArrayList<Reports>();
		//all candidates
		Reports allCandiateReport = new Reports();
		allCandiateReport.setLabel("Total Number of Candidates");
		allCandiateReport.setType("person");
		allCandiateReport.setStyleClass("ui-person");
		allCandiateReport.setExpanded(true);
		Data allCandidateData = new Data();
		allCandidateData.setName(String.valueOf(allCandidateDetails.size()));
		allCandiateReport.setData(allCandidateData);
		
		//first filter by status
		Map<String, List<CandidatureDetails>> filterCandidatebyStatus = allCandidateDetails.stream().
				collect(Collectors.groupingBy(CandidatureDetails::getFinalStatus));
		for(Map.Entry<String, List<CandidatureDetails>> filterCandidates : filterCandidatebyStatus.entrySet() )
		{
			List<Reports> criteriaReports = new ArrayList<Reports>();
			Reports filterReport = new Reports();
			filterReport.setLabel(filterCandidates.getKey());
			Data filterData = new Data();
			filterData.setName(String.valueOf(filterCandidates.getValue().size()));
			filterReport.setType("person");
			filterReport.setStyleClass("ui-person");
			filterReport.setExpanded(true);
			filterReport.setData(filterData);
			
			//second filter by client
			Map<String, List<CandidatureDetails>> filterCandidatebyCriteriaReports = null;
			if(criteria.equalsIgnoreCase("client"))
			{
			filterCandidatebyCriteriaReports = filterCandidates.getValue().stream().
					collect(Collectors.groupingBy(CandidatureDetails::getClient));
			}
			else
			{
				filterCandidatebyCriteriaReports = filterCandidates.getValue().stream().
						collect(Collectors.groupingBy(CandidatureDetails::getPositionLocation));	
			}
			for(Map.Entry<String, List<CandidatureDetails>> filterCandidatebyCriteria : filterCandidatebyCriteriaReports.entrySet() )
			{
				if(filterCandidatebyCriteria.getValue().size()>0)
				{
				Reports secondfilterReport = new Reports();
				secondfilterReport.setLabel(filterCandidatebyCriteria.getKey());
				Data secondfilterData = new Data();
				secondfilterData.setName(String.valueOf(filterCandidatebyCriteria.getValue().size()));
				secondfilterReport.setType("person");
				secondfilterReport.setStyleClass("ui-person");
				secondfilterReport.setExpanded(true);
				secondfilterReport.setData(secondfilterData);
				criteriaReports.add(secondfilterReport);
				}
			}
			filterReport.setChildren(criteriaReports);
			statusReports.add(filterReport);
		}
		allCandiateReport.setChildren(statusReports);
		finalReports.add(allCandiateReport);			
	return finalReports;
	}

}
