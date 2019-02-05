/**
 * 
 */
package com.app.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.UserDetails;
import com.app.services.UserDetailsService;

/**
 * @author Rajasekar.Murugesan
 *
 */

@RestController
@RequestMapping("/usersapi")
@CrossOrigin("*")
public class UserDetailsController {

	
	@Autowired
	private UserDetailsService userDetailsService;
	

	@GetMapping("/userDetails")
    public List<UserDetails> getAllUserDetails() {
		return userDetailsService.findAll();
    }
	
	@GetMapping(value="/userDetails/username/{username}")
    public UserDetails getUserDetails(@PathVariable("username")String username) {
		return userDetailsService.findByUserName(username);
    }

    @PostMapping("/userDetails")
    public UserDetails createUserDetails(@Valid @RequestBody UserDetails userDetail) {
        return userDetailsService.save(userDetail);
    }

    @GetMapping(value="/userDetails/{id}")
    public ResponseEntity<UserDetails> getUserDetailsById(@PathVariable("id") String id) {
        Optional<UserDetails> empDetails = userDetailsService.getUserDetailsById(id);
    	return empDetails.map(emp -> ResponseEntity.ok().body(emp))
    	.orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/userDetails/{id}")
    public ResponseEntity<UserDetails> updateEmployeeDeta(@PathVariable("id") String id,
                                           @Valid @RequestBody UserDetails empDt) {
        UserDetails empDetails = userDetailsService.updateUserDetails(id, empDt);
        Optional<UserDetails> optEmpDet = Optional.of(empDetails);
        return optEmpDet.map(e -> ResponseEntity.ok().body(e))
        		.orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/userDetails/{id}")
    public ResponseEntity<?> deleteUserDetails(@PathVariable("id") String id) {
        try {
        	userDetailsService.deleteUserDetails(id);
            return ResponseEntity.ok().build();
        }catch(Exception e) {
        	return ResponseEntity.notFound().build();
        }
         
    }
	


}
