/**
 * 
 */
package com.app.services;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.multipart.MultipartFile;

import com.app.models.CandidatureDetails;
import com.app.models.ClientDetails;
import com.app.models.EmployeeDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
public interface ParseExcelFileService {
	
	
<<<<<<< HEAD
	List<CandidatureDetails> readExcelFile(MultipartFile file) throws ParseException;
=======
	List<EmployeeDetails> readFile(Sheet sheet);
	
	
	List<CandidatureDetails> readExcelFile(Sheet sheet) throws InvalidExcelFormatException, IOException, InvalidFormatException;
>>>>>>> refs/remotes/origin/HRApplicationRelease1.0
	
	List<ClientDetails> readClientsFile(Sheet sheet) throws InvalidExcelFormatException ;

}
