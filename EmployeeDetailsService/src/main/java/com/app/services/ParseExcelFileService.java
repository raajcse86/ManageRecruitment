/**
 * 
 */
package com.app.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.models.EmployeeDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
public interface ParseExcelFileService {
	
	
	List<EmployeeDetails> readFile(MultipartFile file);

}
