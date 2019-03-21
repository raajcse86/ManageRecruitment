package com.app.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.models.CandidatureDetails;
import com.app.models.Summary;
import com.app.services.CandidatureDetailsService;
import com.app.services.ClientDetailsService;
import com.google.gson.Gson;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sendgrid.Attachments;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Component
public class GeneratePdfReport {

	@Autowired
	SendGrid sendGrid;

	@Autowired
	private ClientDetailsService clientDetailsService;
	@Autowired
	private CandidatureDetailsService candidatureDetailsService;

	public Document generateReport() {
		
		System.out.println("::::::::::::::::::::::::::::::::  schedular runner ::::::::::::::::::::::::::::::::::::::");

		Document document = new Document();

		List<Summary> summary = clientDetailsService.getSummaryData();
		List<CandidatureDetails> candidatureDetails = candidatureDetailsService.findAll();
		clientReport(document, summary);
		candidateReport(document, candidatureDetails);
		return document;
	}
	
	public void sendReportsInEmail()
	{
		 	String fromAddress ="hr.approvals@in.ey.com";
			Email from = new Email(fromAddress );
		    String toAddress ="soni2.kumari@in.ey.com";
			Email to = new Email(toAddress);
		    String subject = "candidates and clients reports";
			System.out.println("TO address is "+toAddress+" Subject is "+subject);
		    String message = "<h1>Please find the attachement for client and candidate pdf reports</h1>";
		    Content content = new Content("text/html", message);
		   
		    
		    Mail mail = new Mail(from, subject, to, content);
		    //Attachement in email
		    Attachments attachments = new Attachments();
		    Attachments attachment2 = new Attachments();
		    Path pdfPath = Paths.get("C:\\Users\\soni2.kumari\\Desktop\\client\\candidate.pdf");
		    Path pdfPath2 = Paths.get("C:\\Users\\soni2.kumari\\Desktop\\client\\client.pdf");
            byte[] fileData = null;
            byte[] fileData2 = null;
            try {
                fileData =Files.readAllBytes(pdfPath);
                fileData2 =Files.readAllBytes(pdfPath2);
            } catch (IOException ex) {
            }
		    attachments.setContent(new org.apache.tomcat.util.codec.binary.Base64().encodeAsString(fileData));
		    attachments.setType("application/pdf");
		    attachments.setFilename("candidate_Report.pdf");
		    attachments.setDisposition("attachment");
		    //attachments.setContentId("Balance Sheet");
		    attachment2.setContent(new org.apache.tomcat.util.codec.binary.Base64().encodeAsString(fileData2));
		    attachment2.setType("application/pdf");
		    attachment2.setFilename("client_Report.pdf");
		    attachment2.setDisposition("attachment");
		   // attachment2.setContentId("Balance Sheet");
		    
		    
		    mail.addAttachments(attachments);

		    mail.addAttachments(attachment2);
		    //end attachment
		    
		    Request request = new Request();
		    Response response = null;
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      response = sendGrid.api(request);
		    } catch (IOException ex) {
		     ex.printStackTrace();
		    }
	}

	// client table
	public Document clientReport(Document document2, List<Summary> summary) {
			Document document = new Document();
			System.out.println(new Gson().toJson(summary));
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(90);
			table.setWidths(new int[] { 1, 3, 3, 3, 3, 3, 3, 3 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("SN", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Client Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Target", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Screening In Progress", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Interview In Progress", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Offer In Progress", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("OfferReleased", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Joined", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			int sn = 1;
			for (Summary summary1 : summary) {

				PdfPCell cell;
				// SN
				cell = new PdfPCell(new Phrase(String.valueOf(sn++)));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				// Client name
				cell = new PdfPCell(new Phrase(summary1.getClientName()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);

				// Target
				int target = summary1.getTarget();

				// cell = new PdfPCell(new Phrase(String.valueOf(target)));
				cell = new PdfPCell(new Phrase(target));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				// Screening In Progress

				int ScreeningInProgress = summary1.getScreeningInProgress();

				cell = new PdfPCell(new Phrase(ScreeningInProgress));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				// Interview In Progress
				int interviewInProgress = summary1.getInterviewInProgress();

				cell = new PdfPCell(new Phrase(interviewInProgress));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				// Offer In Progress
				int OfferInProgress = summary1.getInterviewInProgress();

				cell = new PdfPCell(new Phrase(String.valueOf(OfferInProgress)));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(5);
				table.addCell(cell);

				// OfferReleased
				int offerReleased = summary1.getOfferReleased();
				cell = new PdfPCell(new Phrase(String.valueOf(offerReleased)));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(5);
				table.addCell(cell);

				// Joined
				int joined = summary1.getJoined();

				cell = new PdfPCell(new Phrase(String.valueOf(joined)));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(5);
				table.addCell(cell);

			}

			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);

			document.close();

		} catch (DocumentException ex) {

			Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
		}

		byte[] bytes = out.toByteArray();
		File someFile = new File("C:\\Users\\soni2.kumari\\Desktop\\client\\client.pdf");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(someFile);
			fos.write(bytes);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;

	}

	public Document candidateReport(Document document2, List<CandidatureDetails> candidatureDetails) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(7);
			table.setWidthPercentage(90);
			table.setWidths(new int[] { 1, 3, 3, 3, 3, 3, 3 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("SN", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Client", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Skill", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Status", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Location", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("EXP Joining", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			int sn = 1;
			for (CandidatureDetails candidatureDetails1 : candidatureDetails) {

				PdfPCell cell;
				// SN
				cell = new PdfPCell(new Phrase(String.valueOf(sn++)));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				// Candidate name
				cell = new PdfPCell(new Phrase(candidatureDetails1.getCandidateName()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);

				// Client
				String clientName = candidatureDetails1.getClient();
				if (null == clientName) {
					clientName = "";
				}
				cell = new PdfPCell(new Phrase(clientName.toString()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				// skill

				String skill = candidatureDetails1.getRoleOfResponsibilities();
				if (null == skill)
					skill = "";
				cell = new PdfPCell(new Phrase(skill.toString()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				// status
				String status = candidatureDetails1.getStatus();
				if (null == status)
					status = "";
				cell = new PdfPCell(new Phrase(status.toString()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				// location
				String location = candidatureDetails1.getCurrentLocation();
				if (null == location)
					location = "";
				cell = new PdfPCell(new Phrase(String.valueOf(location.toString())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(5);
				table.addCell(cell);

				// EXjoining
				String exJoining = candidatureDetails1.getExpectedJoiningDate();
				if (null == exJoining)
					exJoining = "";
				cell = new PdfPCell(new Phrase(String.valueOf(exJoining.toString())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(5);
				table.addCell(cell);

			}

			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);

			document.close();

		} catch (DocumentException ex) {

			Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
		}

		byte[] bytes = out.toByteArray();
		File someFile = new File("C:\\Users\\soni2.kumari\\Desktop\\client\\candidate.pdf");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(someFile);
			fos.write(bytes);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;

	}
}
