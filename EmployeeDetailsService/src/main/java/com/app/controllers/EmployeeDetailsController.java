/**
 * 
 */
package com.app.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.EmployeeDetails;
import com.app.services.EmployeeDetailsService;
/**
 * @author Rajasekar.Murugesan
 *
 */

@RestController
@RequestMapping("/api")
public class EmployeeDetailsController {
	
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	

	@GetMapping("/employeeDetails")
    public List<EmployeeDetails> getAllEmployeeDetails() {
		return employeeDetailsService.findAll();
    }

    @PostMapping("/employeeDetails")
    public EmployeeDetails createEmployeeDetails(@Valid @RequestBody EmployeeDetails todo) {
        return employeeDetailsService.save(todo);
    }

    @GetMapping(value="/employeeDetails/{id}")
    public ResponseEntity<EmployeeDetails> getEmployeeDetailsById(@PathVariable("id") String id) {
        Optional<EmployeeDetails> empDetails = employeeDetailsService.getEmployeeDetailsById(id);
    	return empDetails.map(emp -> ResponseEntity.ok().body(emp))
    	.orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/employeeDetails/{id}")
    public ResponseEntity<EmployeeDetails> updateEmployeeDeta(@PathVariable("id") String id,
                                           @Valid @RequestBody EmployeeDetails empDt) {
        EmployeeDetails empDetails = employeeDetailsService.updateEmployeeDetails(id, empDt);
        Optional<EmployeeDetails> optEmpDet = Optional.of(empDetails);
        return optEmpDet.map(e -> ResponseEntity.ok().body(e))
        		.orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/employeeDetails/{id}")
    public ResponseEntity<?> deleteEmployeeDetails(@PathVariable("id") String id) {
        try {
        	employeeDetailsService.deleteEmployeeDetails(id);
            return ResponseEntity.ok().build();
        }catch(Exception e) {
        	return ResponseEntity.notFound().build();
        }
         
    }
	
}
