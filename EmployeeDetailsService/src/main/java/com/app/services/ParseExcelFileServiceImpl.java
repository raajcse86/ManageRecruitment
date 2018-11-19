/**
 * 
 */
package com.app.services;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.app.models.EmployeeDetails;

/**
 * @author Rajasekar.Murugesan
 *
 */
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
						System.out.print("cellValue >> "+cellValue + "\t");
						System.out.print("colIndex >> "+colIndex + "\t");
						switch(colIndex) {
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

}
