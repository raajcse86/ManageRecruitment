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
public class RoleDetailsServiceImpl implements RoleDetailsService {

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
	
	

}
