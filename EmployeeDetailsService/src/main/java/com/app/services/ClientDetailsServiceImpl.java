package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.CandidatureDetails;
import com.app.models.ClientDetails;
import com.app.models.Summary;
import com.app.repositories.CandidatureDetailsRepository;
import com.app.repositories.ClientDetailsRepository;

/**
 * @author Madhamanchi Nikhil Chowdary
 *
 */

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Autowired
	private ClientDetailsRepository clientDetailsRepository;

	@Autowired
	private CandidatureDetailsRepository candidatureDetailsRepository;

	@Override
	public List<ClientDetails> findAll() {
		return clientDetailsRepository.findAll();
	}

	@Override
	public void save(ClientDetails clientDetails) {
		clientDetails.setCreatedDate(new DateTime().plusHours(5).plusMinutes(30).toDate());
		clientDetailsRepository.save(clientDetails);
	}

	@Override
	public Optional<ClientDetails> findClientDetailsById(String id) {
		return clientDetailsRepository.findById(id);
	}

	@Override
	public ClientDetails updateClientDetails(String id, ClientDetails clientDetails) {
		Optional<ClientDetails> client = clientDetailsRepository.findById(id);
		ClientDetails details = client.get();
		return clientDetailsRepository.save(details);
	}

	@Override
	public void deleteClientDetails(String id) {
		clientDetailsRepository.deleteById(id);

	}

	@Override
	public List<ClientDetails> updateListOfClientDetails(List<ClientDetails> clientDetailsFrmExternalSystem) {

		for (ClientDetails clientDetails : clientDetailsFrmExternalSystem) {

			List<ClientDetails> clientDetailsFrmDb = clientDetailsRepository
					.findByClientName(clientDetails.getClientName());

			if (clientDetailsFrmDb.size() > 0) {
				clientDetails.setCreatedDate(clientDetailsFrmDb.get(0).getCreatedDate());
				clientDetailsRepository.deleteAll(clientDetailsFrmDb);
				clientDetails.setUpdateDate(new DateTime().plusHours(5).plusMinutes(50).toDate());
				clientDetailsRepository.save(clientDetails);
			} else {
				clientDetails.setCreatedDate(new DateTime().plusHours(5).plusMinutes(30).toDate());
				clientDetailsRepository.save(clientDetails);
			}
		}
		return clientDetailsRepository.findAll();
	}

	@Override
	public void saveAll(List<ClientDetails> clientDetails) {
		clientDetailsRepository.saveAll(clientDetails);
	}

	@Override
	public List<ClientDetails> findAllClients() {
		return clientDetailsRepository.findAll();
	}

	@Override
	public List<Summary> getSummaryData() {

		List<ClientDetails> clientDetailsList = clientDetailsRepository.findAll();
		List<Summary> summaryList = new ArrayList<>();

		for (ClientDetails clientDetail : clientDetailsList) {
			Summary summary = new Summary();

			Integer joined = 0;
			Integer offerReleased = 0;
			Integer offerInProgress = 0;
			Integer interviewInProgress = 0;
			Integer screeningInProgress = 0;

			List<CandidatureDetails> candidatureDetails = candidatureDetailsRepository
					.findByClient(clientDetail.getClientName());
			if (null != candidatureDetails && candidatureDetails.size() > 0) {

				for (CandidatureDetails details : candidatureDetails) {
					try {
						if (details.getProfileStatus().equalsIgnoreCase("Active")) {

							if (details.getFinalStatus().equalsIgnoreCase("Interviews in Progress")) {
								interviewInProgress = interviewInProgress + 1;
							} else if (details.getFinalStatus().equalsIgnoreCase("Joined")) {
								joined = joined + 1;
							} else if (details.getFinalStatus().equalsIgnoreCase("Offer in Progress")) {
								offerInProgress = offerInProgress + 1;
							} else if (details.getFinalStatus().equalsIgnoreCase("Offer Released")) {
								offerReleased = offerReleased + 1;
							} else if (details.getFinalStatus().equalsIgnoreCase("Screening in Progress")) {
								screeningInProgress = screeningInProgress + 1;
							}
						}
					}

					catch (Exception e) {
						System.out.println("details &&&&&&&&&&& " + details.toString());
						e.printStackTrace();
					}
				}
				summary.setClientName(clientDetail.getClientName());
				summary.setContractMechanism(clientDetail.getContractMechanism());
				summary.setInterviewInProgress(interviewInProgress);
				summary.setJoined(joined);
				summary.setLeadName(clientDetail.getLeadName());
				summary.setLocation(clientDetail.getLocation());
				summary.setOfferInProgress(offerInProgress);
				summary.setOfferReleased(offerReleased);
				summary.setScreeningInProgress(screeningInProgress);
				summary.setSkill(clientDetail.getSkill());
				summary.setTarget(Integer.valueOf(clientDetail.getTarget()));
				summaryList.add(summary);
			}

		}

		return summaryList;
	}

}
