package edu.chart.demo.dto;

import java.util.ArrayList;
import java.util.List;

import edu.chart.demo.Convertable;

public class CircularChartDTO implements Convertable {

	public CircularDataSet createDataSet() {
		return new CircularDataSet();
	}

	private List<CircularDataSet> dataSet;

	public CircularChartDTO() {
		super();
		dataSet = new ArrayList<CircularChartDTO.CircularDataSet>();
	}

	public List<CircularDataSet> getDataSet() {
		return dataSet;
	}

	public void setDataSet(List<CircularDataSet> dataSet) {
		this.dataSet = dataSet;
	}

	public class CircularDataSet {
		private String color;
		private String highlight;
		private String label;
		private Double value;

		public CircularDataSet() {
			super();
			color = "#F7464A";
			highlight = "#FF5A5E";
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getHighlight() {
			return highlight;
		}

		public void setHighlight(String highlight) {
			this.highlight = highlight;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}
	}
}
