/**
 * 
 */
package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.models.EmployeeDetails;
import com.app.models.UserDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
public interface UserDetailsService {
	List<UserDetails> findAll();
	UserDetails save(UserDetails userDetails);
	Optional<UserDetails> getUserDetailsById(String id);
	UserDetails updateUserDetails(String id, UserDetails emp);
	void deleteUserDetails(String id);

}
