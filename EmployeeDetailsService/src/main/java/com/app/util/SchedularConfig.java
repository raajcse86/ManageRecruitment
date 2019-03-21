package com.app.util;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.controllers.GeneratePdfReport;

@Component
public class SchedularConfig {
	@Autowired
	GeneratePdfReport pdfReport;
	//@Scheduled(cron="0 0/1 * * * ?")
	//cron expression for every friday at 1 pm 
	@Scheduled(cron="0 0 13 * * FRI")
	public void generateReports() {
		pdfReport.generateReport();
		pdfReport.sendReportsInEmail();
	}

}
