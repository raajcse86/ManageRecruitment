package com.app.models;

import java.util.List;

public class Chart {
	
	private List<String> chartLabels;
	private List<ChartDataSet> chartDatasets;
	private int yaxisScale;
	public List<String> getChartLabels() {
		return chartLabels;
	}
	public List<ChartDataSet> getChartDatasets() {
		return chartDatasets;
	}
	public void setChartLabels(List<String> chartLabels) {
		this.chartLabels = chartLabels;
	}
	public void setChartDatasets(List<ChartDataSet> chartDatasets) {
		this.chartDatasets = chartDatasets;
	}
	public int getYaxisScale() {
		return yaxisScale;
	}
	public void setYaxisScale(int yaxisScale) {
		this.yaxisScale = yaxisScale;
	}
	

}
