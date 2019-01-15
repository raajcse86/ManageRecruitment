package com.app.models;

import java.util.List;

public class ChartDataSet {
	
	private List<Integer> data;
	private String label;
	private String backgroundColor;
	private String borderColor;
	public List<Integer> getData() {
		return data;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
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
