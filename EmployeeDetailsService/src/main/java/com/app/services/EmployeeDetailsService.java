/**
 * 
 */
package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.models.EmployeeDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
public interface EmployeeDetailsService {
	List<EmployeeDetails> findAll();
    EmployeeDetails save(EmployeeDetails employeeDetails);
	Optional<EmployeeDetails> getEmployeeDetailsById(String id);
	EmployeeDetails updateEmployeeDetails(String id, EmployeeDetails emp);
	void deleteEmployeeDetails(String id);
	List<EmployeeDetails> updateListOfEmployeeDetails(List<EmployeeDetails> empDetails);

}
