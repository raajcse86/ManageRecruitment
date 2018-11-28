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
				System.out.println("=> " + sheet.getSheetName());
				// Create a DataFormatter to format and get each cell's value as String
				DataFormatter dataFormatter = new DataFormatter();
				// 1. You can obtain a rowIterator and columnIterator and iterate over them
				System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
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
						System.out.print("cellValue >> " + cellValue + "\t");
						System.out.print("colIndex >> " + colIndex + "\t");
						switch (colIndex) {
						case 1:
							details.setName(cellValue);
							break;
						case 2:
							details.setEmail(cellValue);
						case 3:
							details.setStatus(cellValue);
						}

					}
					listEmp.add(details);
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
			System.out.println("Retrieving Sheets using Iterator");

			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				System.out.println("=> " + sheet.getSheetName());
				if (sheet.getSheetName().equalsIgnoreCase("supply")) {
					int rowIndex = 0;
					// Create a DataFormatter to format and get each cell's value as String
					DataFormatter dataFormatter = new DataFormatter();
					// 1. You can obtain a rowIterator and columnIterator and iterate over them
					System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
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
								System.out.print("cellValue >> " + cellValue + "\t");
								System.out.print("colIndex >> " + colIndex + "\t");
								switch (colIndex) {
								case 1:
									details.setRoleOfResponsibilities(cellValue);
									break;
								case 2:
									details.setPositionLocation(cellValue);
									break;
								case 3:
									details.setCandidateName(cellValue);
									break;
								case 4:
									details.setContactNo(cellValue);
									break;
								case 5:
									details.setEmailId(cellValue);
									break;
								case 6:
									details.setTotalExperience(cellValue);
									break;
								case 7:
									details.setRelevantExperience(cellValue);
									break;
								case 8:
									details.setNoticePeriod(cellValue);
									break;
								case 9:
									details.setCurrentLocation(cellValue);
									break;
								case 10:
									details.setPreferredLocation(cellValue);
									break;
								case 11:
									details.setModeOfHiring(cellValue);
									break;
								case 12:
									details.setVendorName(cellValue);
									;
									break;
								case 13:
									if(cellValue != null && !cellValue.isEmpty()) {
										details.setProfileSharedDate(cellValue);
										break;	
									}
								case 14:
									details.setScreeningStatus(cellValue);
									break;
								case 15:
									if(cellValue != null && !cellValue.isEmpty()) {
									details.setScreeningDate(cellValue);
									break;
									}
								case 16:
									details.setScreeningDoneBy(cellValue);
									break;

								case 17:
									details.setFirstRoundStatus(cellValue);
									break;
								case 18:
									if(cellValue != null && !cellValue.isEmpty()) {
									details.setFirstRoundDate(cellValue);
									break;
									}
								case 19:
									details.setFirstRoundTakenBy(cellValue);
									break;
								case 20:
									details.setSecondRoundStatus(cellValue);
									break;
								case 21:
									if(cellValue != null && !cellValue.isEmpty()) {
									details.setSecondRoundDate(cellValue);
									break;
									}
								case 22:
									details.setSecondRoundTakenBy(cellValue);
									break;
								case 23:
									details.setFinalRoundStatus(cellValue);
									break;
								case 24:
									if(cellValue != null && !cellValue.isEmpty()) {
									details.setFinalRoundDate(cellValue);
									break;
									}
								case 25:
									details.setFinalRoundTakenBy(cellValue);
									break;
								case 26:
									details.setHrOrPnStageRound(cellValue);
									break;
								case 27:
									details.setHrOrPnStageStatus(cellValue);
									break;
								case 28:
									if(cellValue != null && !cellValue.isEmpty()) {
									details.setHrOrPnStageDate(cellValue);
									break;
									}

								case 29:
									details.setCandidatureStatus(cellValue);
									break;
								case 30:
									if(cellValue != null && !cellValue.isEmpty()) {
									details.setOfferRollOutDate(cellValue);
									break;
									}
								case 31:
									if(cellValue != null && !cellValue.isEmpty()) {
									details.setJoiningDate(cellValue);
									break;
									}
								case 32:
									details.setJoiningStatus(cellValue);
									break;
								case 33:
									details.setNhrId(cellValue);
									break;
								case 34:
									details.setComments(cellValue);
									break;

								case 35:
									details.setAction(cellValue);
									break;
								case 36:
									details.setClient(cellValue);
									break;
								case 37:
									details.setProfile(cellValue);
									break;
								case 38:
									if(cellValue != null && !cellValue.isEmpty()) {
									details.setLastUpdateDate(cellValue);
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

}
