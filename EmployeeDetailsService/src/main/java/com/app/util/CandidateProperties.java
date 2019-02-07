package com.app.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CandidateProperties {
	
	private Properties prop = null;

	public CandidateProperties() {
		InputStream is = null;
		try {
			this.prop = new Properties();
			is = this.getClass().getResourceAsStream("/CandidatesExcel.properties");
			prop.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}
	}
	
	public String getPropertyValue(String key){
        return this.prop.getProperty(key);
    }

}
