/**
 * 
 */
package com.app.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.models.CandidatureDetails;
import com.app.models.EmployeeDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
public interface ParseExcelFileService {
	
	
	List<EmployeeDetails> readFile(MultipartFile file);
	
	
	List<CandidatureDetails> readExcelFile(MultipartFile file) throws ParseException;

}
