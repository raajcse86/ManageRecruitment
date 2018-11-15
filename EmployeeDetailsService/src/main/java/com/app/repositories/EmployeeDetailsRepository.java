/**
 * 
 */
package com.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.models.EmployeeDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
@Repository
public interface EmployeeDetailsRepository extends MongoRepository<EmployeeDetails, String> {

}
