/**
 * 
 */
package com.app.services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.models.CandidatureDetails;
import com.app.models.ClientDetails;
import com.app.models.EmployeeDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
@Service
public class ParseExcelFileServiceImpl implements ParseExcelFileService {

	@Override
	public List<EmployeeDetails> readFile(MultipartFile file) {
		List<EmployeeDetails> listEmp = new ArrayList<>();
		try {
			Workbook workbook = WorkbookFactory.create(file.getInputStream());
			// Retrieving the number of sheets in the Workbook
			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();
			System.out.println("Retrieving Sheets using Iterator");
			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				// Create a DataFormatter to format and get each cell's value as String
				DataFormatter dataFormatter = new DataFormatter();
				// 1. You can obtain a rowIterator and columnIterator and iterate over them
				Iterator<Row> rowIterator = sheet.rowIterator();
				while (rowIterator.hasNext()) {
					EmployeeDetails details = new EmployeeDetails();
					Row row = rowIterator.next();
					// Now let's iterate over the columns of the current row
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						int colIndex = cell.getColumnIndex();
						// System.out.print("cellValue >> " + cellValue + "\t");
						// System.out.print("colIndex >> " + colIndex + "\t");
						/*
						 * switch (colIndex) { case 1: details.setName(cellValue); break; case 2:
						 * details.setEmail(cellValue); case 3: details.setStatus(cellValue); }
						 */
					}
					// listEmp.add(details);
				}
			}
			// Closing the workbook
			workbook.close();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEmp;
	}

	@Override
	public List<CandidatureDetails> readExcelFile(MultipartFile file) throws ParseException {
		List<CandidatureDetails> listEmp = new ArrayList<>();
		try {
			Workbook workbook = WorkbookFactory.create(file.getInputStream());
			// Retrieving the number of sheets in the Workbook
			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();

			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				if (sheet.getSheetName().equalsIgnoreCase("supply")) {
					int rowIndex = 0;
					// Create a DataFormatter to format and get each cell's value as String
					DataFormatter dataFormatter = new DataFormatter();
					// 1. You can obtain a rowIterator and columnIterator and iterate over them
					Iterator<Row> rowIterator = sheet.rowIterator();

					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						if (rowIndex != 0) {
							CandidatureDetails details = new CandidatureDetails();
							// Now let's iterate over the columns of the current row
							Iterator<Cell> cellIterator = row.cellIterator();
							while (cellIterator.hasNext()) {
								Cell cell = cellIterator.next();
								String cellValue = dataFormatter.formatCellValue(cell);
								int colIndex = cell.getColumnIndex();
								switch (colIndex) {
								case 1:
									details.setRoleOfResponsibilities(cellValue);
									break;
								case 2:
									details.setCandidateName(cellValue);
									break;
								case 3:
									details.setContactNo(cellValue);
									break;
								case 4:
									details.setEmailId(cellValue);
									break;
								case 5:
									details.setTotalExperience(cellValue);
									break;
								case 6:
									details.setRelevantExperience(cellValue);
									break;
								case 7:
									details.setNoticePeriod(cellValue);
									break;
								case 8:
									details.setCtc(cellValue);
									break;
								case 9:
									details.setExpectedCTC(cellValue);
									break;
								case 10:
									details.setCurrentLocation(cellValue);
									break;
								case 11:
									details.setPreferredLocation(cellValue);
									break;
								case 12:
									details.setPositionLocation(cellValue);
									break;
								case 13:
									details.setModeOfHiring(cellValue);
									break;
								case 14:
									details.setSource(cellValue);
									break;
								case 15:
									if (cellValue != null && !cellValue.isEmpty()) {
										details.setProfileSharedDate(cellValue);
										break;
									}
								case 16:
									details.setScreeningStatus(cellValue);
									break;
								case 17:
									if (cellValue != null && !cellValue.isEmpty()) {
										details.setScreeningDate(cellValue);
										break;
									}
								case 18:
									details.setScreeningDoneBy(cellValue);
									break;

								case 19:
									details.setFirstRoundStatus(cellValue);
									break;
								case 20:
									if (cellValue != null && !cellValue.isEmpty()) {
										details.setFirstRoundDate(cellValue);
										break;
									}
								case 21:
									details.setFirstRoundTakenBy(cellValue);
									break;
								case 22:
									details.setSecondRoundStatus(cellValue);
									break;
								case 23:
									if (cellValue != null && !cellValue.isEmpty()) {
										details.setSecondRoundDate(cellValue);
										break;
									}
								case 24:
									details.setSecondRoundTakenBy(cellValue);
									break;
								case 25:
									details.setFinalRoundStatus(cellValue);
									break;
								case 26:
									if (cellValue != null && !cellValue.isEmpty()) {
										details.setFinalRoundDate(cellValue);
										break;
									}
								case 27:
									details.setFinalRoundTakenBy(cellValue);
									break;
								case 28:
									details.setHrOrPnStageRound(cellValue);
									break;
								case 29:
									details.setHrOrPnStageStatus(cellValue);
									break;
								case 30:
									if (cellValue != null && !cellValue.isEmpty()) {
										details.setHrOrPnStageDate(cellValue);
										break;
									}
								case 31:
									details.setStatus(cellValue);
									if (details.getStatus().equalsIgnoreCase("1st round scheduled")
											|| details.getStatus().equalsIgnoreCase("1st round to be scheduled")
											|| details.getStatus().equalsIgnoreCase("1st round to be Re-scheduled")
											|| details.getStatus().equalsIgnoreCase("2nd round scheduled")
											|| details.getStatus().equalsIgnoreCase("2nd round to be scheduled")
											|| details.getStatus()
													.equalsIgnoreCase("Client Interview to be Re-scheduled")
											|| details.getStatus().equalsIgnoreCase("Client Interview to be scheduled")
											|| details.getStatus().equalsIgnoreCase("Client Interview scheduled")
											|| details.getStatus().equalsIgnoreCase("Final Round to be scheduled")
											|| details.getStatus().equalsIgnoreCase("Final round scheduled")
											|| details.getStatus().equalsIgnoreCase("Final Round to be rescheduled")
											|| details.getStatus().equalsIgnoreCase("HR round to be scheduled")
											|| details.getStatus().equalsIgnoreCase("HR Round cleared"))
										details.setFinalStatus("Interviews in Progress");
									else if (details.getStatus().equalsIgnoreCase("Joined"))
										details.setFinalStatus("Joined");
									else if (details.getStatus().equalsIgnoreCase("Offer in Progress"))
										details.setFinalStatus("Offer in Progress");
									else if (details.getStatus().equalsIgnoreCase("Offer Released"))
										details.setFinalStatus("Offer Released");
									else if (details.getStatus().equalsIgnoreCase("On hold"))
										details.setFinalStatus("On hold");
									else if (details.getStatus().equalsIgnoreCase("Rejected/Not shortlisted"))
										details.setFinalStatus("Rejected/Not shortlisted");
									else if (details.getStatus().equalsIgnoreCase("Yet to screen"))
										details.setFinalStatus("Screening in Progress");
									break;
								case 33:
									details.setDescription(cellValue);
									break;
								case 34:
									details.setActionPending(cellValue);
									break;
								case 35:
									details.setClient(cellValue);
									break;
								case 36:
									details.setProfileStatus(cellValue);
									break;
								case 37:
									if (cellValue != null && !cellValue.isEmpty()) {
										details.setStatusUpdatedDate(cellValue);
										break;
									}
								case 38:
									if (cellValue != null && !cellValue.isEmpty()) {
										details.setExpectedJoiningDate(cellValue);
										break;
									}
								}

							}
							listEmp.add(details);
						}
						rowIndex++;
					}

				}
			}
			// Closing the workbook
			workbook.close();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEmp;
	}

	public Date convertToDate(String s) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("MM/DD/YY");
		Date date = (Date) formatter.parse(s);
		return date;
	}

	@Override
	public List<ClientDetails> readClientsFile(MultipartFile file) throws ParseException {
		List<ClientDetails> clientDetails = new ArrayList<>();
		try {
			Workbook workbook = WorkbookFactory.create(file.getInputStream());
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();

			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				System.out.println("=> " + sheet.getSheetName());
				if (sheet.getSheetName().equalsIgnoreCase("Client_Requirements")) {
					int rowIndex = 0;
					// Create a DataFormatter to format and get each cell's value as String
					DataFormatter dataFormatter = new DataFormatter();
					// 1. You can obtain a rowIterator and columnIterator and iterate over them
					Iterator<Row> rowIterator = sheet.rowIterator();

					while (rowIterator.hasNext()) {
						Row row = rowIterator.next();
						if (rowIndex != 0) {
							ClientDetails details = new ClientDetails();
							// Now let's iterate over the columns of the current row
							Iterator<Cell> cellIterator = row.cellIterator();
							while (cellIterator.hasNext()) {
								Cell cell = cellIterator.next();
								String cellValue = dataFormatter.formatCellValue(cell);
								int colIndex = cell.getColumnIndex();
								switch (colIndex) {
								case 1:
									details.setClientName(cellValue);
									break;
								case 2:
									details.setLeadName(cellValue);
									break;
								case 3:
									details.setLocation(cellValue);
									break;
								case 4:
									details.setSkill(cellValue);
									break;
								case 5:
									details.setContractMechanism(cellValue);
									break;
								case 6:
									details.setTarget(cellValue);
									break;
								}

							}
							clientDetails.add(details);
						}
						rowIndex++;
					}

				}
			}
			workbook.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clientDetails;
	}

}
