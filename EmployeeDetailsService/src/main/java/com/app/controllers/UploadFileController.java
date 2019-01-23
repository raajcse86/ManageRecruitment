/**
 * 
 */
package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.models.CandidatureDetails;
import com.app.models.ClientDetails;
import com.app.models.EmployeeDetails;
import com.app.services.CandidatureDetailsService;
import com.app.services.ClientDetailsService;
import com.app.services.EmployeeDetailsService;
import com.app.services.ParseExcelFileService;

/**
 * @author Rajasekar.Murugesan
 *
 */
@CrossOrigin("*")
@RestController
public class UploadFileController {

	@Autowired
	private ParseExcelFileService parseExcelFileService;

	@Autowired
	private EmployeeDetailsService employeeDetailsService;

	@Autowired
	private CandidatureDetailsService candidatureDetailsService;

	@Autowired
	private ClientDetailsService clientDetailsService;

	/*
	 * MultipartFile Upload
	 */
	@PostMapping("/api/file/upload")
	public String uploadMultipartFile(@RequestParam("file") MultipartFile file) {
		try {
			List<EmployeeDetails> empList = parseExcelFileService.readFile(file);
			employeeDetailsService.updateListOfEmployeeDetails(empList);
		} catch (Exception e) {
			return "FAIL! employeeDetails:: Maybe You had uploaded the file before or the file's size > 500KB";
		}
		try {
			List<ClientDetails> clientDetails = parseExcelFileService.readClientsFile(file);
			System.out.println("Client details size is :: " + clientDetails.size());
			clientDetailsService.updateListOfClientDetails(clientDetails);
		} catch (Exception e) {
			return "FAIL! clientDetails:: Maybe You had uploaded the file before or the file's size > 500KB";
		}
		try {
			List<CandidatureDetails> candidateList = parseExcelFileService.readExcelFile(file);
			candidatureDetailsService.updateListOfCandidatureDetails(candidateList);
		} catch (Exception e) {
			return "FAIL! candidatureDetails:: Maybe You had uploaded the file before or the file's size > 500KB";
		}
		
		// save file to PostgreSQL
		// FileModel filemode = new FileModel(file.getOriginalFilename(),
		// file.getContentType(), file.getBytes());
		// fileRepository.save(filemode);
		return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
	}
}
