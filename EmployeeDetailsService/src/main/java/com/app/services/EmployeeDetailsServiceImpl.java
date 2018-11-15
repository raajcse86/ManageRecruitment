/**
 * 
 */
package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.EmployeeDetails;
import com.app.repositories.EmployeeDetailsRepository;

/**
 * @author Rajasekar.Murugesan
 *
 */
@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
	
	@Override
	public List<EmployeeDetails> findAll() {
		return employeeDetailsRepository.findAll();
	}

	@Override
	public EmployeeDetails save(EmployeeDetails employeeDetails) {
		return employeeDetailsRepository.save(employeeDetails);
	}

	@Override
	public Optional<EmployeeDetails> getEmployeeDetailsById(String id) {
		return employeeDetailsRepository.findById(id);
               
	}

	@Override
	public EmployeeDetails updateEmployeeDetails(String id, EmployeeDetails empDetails) {
		Optional<EmployeeDetails> emp = employeeDetailsRepository.findById(id);
		EmployeeDetails details = emp.get();
		details.setName(empDetails.getName());
		details.setEmail(empDetails.getEmail());
		details.setStatus(empDetails.getStatus());
		return employeeDetailsRepository.save(details);
		
	}

	@Override
	public void deleteEmployeeDetails(String id) {
		employeeDetailsRepository.deleteById(id);
	}

}
