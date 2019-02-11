/**
 * 
 */
package com.app.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.multipart.MultipartFile;

import com.app.models.CandidatureDetails;
import com.app.models.ClientDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
public interface ParseExcelFileService {
	
	
	List<CandidatureDetails> readExcelFile(MultipartFile file) throws ParseException;
	List<CandidatureDetails> readExcelFile(Sheet sheet) throws InvalidExcelFormatException, IOException, InvalidFormatException;
	List<ClientDetails> readClientsFile(Sheet sheet) throws InvalidExcelFormatException ;

}
