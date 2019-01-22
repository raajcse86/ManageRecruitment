/**
 * 
 */
package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.models.UserDetails;
import com.app.repositories.UserDetailsRepository;

/**
 * @author Rajasekar.Murugesan
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Override
	public List<UserDetails> findAll() {
		return userDetailsRepository.findAll();
	}

	@Override
	public UserDetails save(UserDetails UserDetails) {
		UserDetails.setPassword(new BCryptPasswordEncoder().encode(UserDetails.getPassword()));
		return userDetailsRepository.save(UserDetails);
	}

	@Override
	public Optional<UserDetails> getUserDetailsById(String id) {
		return userDetailsRepository.findById(id);
               
	}

	@Override
	public UserDetails updateUserDetails(String id, UserDetails userDetails) {
		Optional<UserDetails> emp = userDetailsRepository.findById(id);
		UserDetails details = emp.get();
		details.setUsername(userDetails.getUsername());
		details.setRole(userDetails.getRole());
		return userDetailsRepository.save(details);
		
	}

	@Override
	public void deleteUserDetails(String id) {
		userDetailsRepository.deleteById(id);
	}

	@Override
	public UserDetails findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDetailsRepository.findByUsername(username);
	}

}
