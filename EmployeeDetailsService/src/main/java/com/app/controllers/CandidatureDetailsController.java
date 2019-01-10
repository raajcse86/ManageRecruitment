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

import com.app.models.CandidatureDetails;
import com.app.models.Chart;
import com.app.models.EmployeeDetails;
import com.app.services.CandidatureDetailsService;
/**
 * @author Rajasekar.Murugesan
 *
 */

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CandidatureDetailsController {
	
	@Autowired
	private CandidatureDetailsService candidatureDetailsService;
	

	@GetMapping("/candidatureDetails")
    public List<CandidatureDetails> getAllCandidatureDetailsDetails() {
		return candidatureDetailsService.findAll();
    }
	
	@GetMapping("/candidatureDetailsBy/{criteria}")
    public Chart getAllCandidatureDetailsByCriteria(@PathVariable("criteria") String criteria) {
	   return candidatureDetailsService.findCandidatesByCriteria(criteria);
    }
	
	@GetMapping("/candidatureDetailsBy/{criteria}/{category}/and/{type}")
    public List<CandidatureDetails> getAllCandidatureDetailsByCriteriaAndType(@PathVariable("criteria") String criteria,@PathVariable("type") String type,@PathVariable("category") String category) {
	   return candidatureDetailsService.findCandidatureDetailsByCategoryCriteriaAndType(criteria,category,type);
    }


    @PostMapping("/candidatureDetails")
    public CandidatureDetails createEmployeeDetails(@Valid @RequestBody CandidatureDetails todo) {
        return candidatureDetailsService.save(todo);
    }

    @GetMapping(value="/candidatureDetails/{id}")
    public ResponseEntity<CandidatureDetails> getEmployeeDetailsById(@PathVariable("id") String id) {
        Optional<CandidatureDetails> empDetails = candidatureDetailsService.getCandidatureDetailsById(id);
    	return empDetails.map(emp -> ResponseEntity.ok().body(emp))
    	.orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/candidatureDetails/{id}")
    public ResponseEntity<CandidatureDetails> updateCandidatureData(@PathVariable("id") String id,
                                           @Valid @RequestBody CandidatureDetails empDt) {
    	CandidatureDetails empDetails = candidatureDetailsService.updateCandidatureDetails(id, empDt);
        Optional<CandidatureDetails> optEmpDet = Optional.of(empDetails);
        return optEmpDet.map(e -> ResponseEntity.ok().body(e))
        		.orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/candidatureDetails/{id}")
    public ResponseEntity<?> deleteCandidatureDetails(@PathVariable("id") String id) {
        try {
        	candidatureDetailsService.deleteCandidatureDetails(id);
            return ResponseEntity.ok().build();
        }catch(Exception e) {
        	return ResponseEntity.notFound().build();
        }
         
    }
	
}
