/**
 * 
 */
package com.app.controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.models.CandidatureDetails;
import com.app.models.ClientDetails;
import com.app.models.ExceptionModel;
import com.app.services.CandidatureDetailsService;
import com.app.services.ClientDetailsService;
import com.app.services.InvalidExcelFormatException;
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

	/*
	 * @Autowired private EmployeeDetailsService employeeDetailsService;
	 */

	@Autowired
	private CandidatureDetailsService candidatureDetailsService;

	@Autowired
	private ClientDetailsService clientDetailsService;

	/*
	 * MultipartFile Upload
	 */
	@PostMapping("/api/file/upload")
	public ResponseEntity<ExceptionModel> uploadMultipartFile(@RequestParam("file") MultipartFile file) {
		try {
			/*
			 * List<EmployeeDetails> empList = parseExcelFileService.readFile(file);
			 * employeeDetailsService.updateListOfEmployeeDetails(empList);
			 */
			Workbook workbook = WorkbookFactory.create(file.getInputStream());
			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();
			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				if (sheet.getSheetName().equalsIgnoreCase("supply")) {
					if (sheet.getPhysicalNumberOfRows() > 2) {
						List<CandidatureDetails> candidateList = parseExcelFileService.readExcelFile(sheet);

						if (candidateList != null && candidateList.size() > 0) {
							int count = 0;
							for (CandidatureDetails candidatureDetails : candidateList) {
								String emainId = candidatureDetails.getEmailId();
								String candidateName = candidatureDetails.getCandidateName();
								if (candidateName == null || emainId == null || emainId.equalsIgnoreCase("null")
										|| candidateName.equalsIgnoreCase("null") || candidateName.trim().equals("")
										|| emainId.trim().equals("")) {
									count = count + 1;
								}
							}
							if (count <= 0) {
								candidatureDetailsService.updateListOfCandidatureDetails(candidateList);
							} else {
								throw new InvalidExcelFormatException(
										"CandidateName/ EmailId should not be empty or null");
							}
						} else {
							throw new InvalidExcelFormatException(
									"No Records found in " + sheet.getSheetName() + " sheet");
						}

					}
				}

				else if (sheet.getSheetName().equalsIgnoreCase("Client_Requirements")) {
					if (sheet.getPhysicalNumberOfRows() > 2) {
						List<ClientDetails> clientDetails = parseExcelFileService.readClientsFile(sheet);

						if (clientDetails != null && clientDetails.size() > 0) {
							System.out.println("Client details size is :: " + clientDetails.size());
							clientDetailsService.updateListOfClientDetails(clientDetails);
						}

					} else {
						throw new InvalidExcelFormatException("No Records found in " + sheet.getSheetName() + " sheet");
					}
				}

			}
			workbook.close();

		} catch (InvalidExcelFormatException e1) {
			ExceptionModel exceptionModel = new ExceptionModel();
			exceptionModel.setCode(401);
			exceptionModel.setMessage(e1.getMessage());
			exceptionModel.setStatus("Failed");
			return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.BAD_REQUEST);
		} catch (InvalidFormatException e) {
			ExceptionModel exceptionModel = new ExceptionModel();
			exceptionModel.setCode(401);
			exceptionModel.setMessage(e.getMessage());
			exceptionModel.setStatus("Failed");
			return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.BAD_REQUEST);
		} catch (IOException e) {
			ExceptionModel exceptionModel = new ExceptionModel();
			exceptionModel.setCode(401);
			exceptionModel.setMessage(e.getMessage());
			exceptionModel.setStatus("Failed");
			return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ExceptionModel exceptionModel = new ExceptionModel();
			exceptionModel.setCode(401);
			exceptionModel.setMessage("Something goes wrong");
			exceptionModel.setStatus("Failed");
			return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.BAD_REQUEST);
		}
		ExceptionModel exceptionModel = new ExceptionModel();
		exceptionModel.setCode(200);
		exceptionModel.setMessage("File uploaded successfully! -> filename = " + file.getOriginalFilename());
		exceptionModel.setStatus("Success");
		return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.OK);
	}
}
