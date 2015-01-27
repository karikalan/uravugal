package edu.chart.demo.vo;

import java.util.ArrayList;
import java.util.List;


public class CharDataVO {
	private List<String> labels;
	private List<DataSetVO> datasets;
		
	public CharDataVO() {
		super();
		labels = new ArrayList<String>();
		datasets = new ArrayList<DataSetVO>();
	}
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public List<DataSetVO> getDatasets() {
		return datasets;
	}
	public void setDatasets(List<DataSetVO> datasets) {
		this.datasets = datasets;
	}
	@Override
	public String toString() {
		return "CharDataVO [labels=" + labels + ", datasets=" + datasets + "]";
	}	
}
