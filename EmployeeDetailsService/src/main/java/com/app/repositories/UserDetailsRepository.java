/**
 * 
 */
package com.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.models.UserDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

}
