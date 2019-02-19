package com.app.models;

import java.util.List;

public class ChartDataSet {
	
	private List<Integer> data;
	private String label;
	
	public List<Integer> getData() {
		return data;
	}
	public String getLabel() {
		return label;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
