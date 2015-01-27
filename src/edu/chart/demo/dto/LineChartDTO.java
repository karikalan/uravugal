package edu.chart.demo.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import edu.chart.demo.Convertable;

public class LineChartDTO implements Convertable{
	private Set<String> labels;
	private List<DataSetDTO> datasets;
	
	public DataSetDTO createDataSetDTO(){
		return new DataSetDTO();
	}

	public class DataSetDTO {

		// private String label;
		private String fillColor = "rgba(220,220,220,0.2)";
		private String strokeColor = "rgba(220,220,220,1)";
		private String pointColor = "rgba(220,220,220,1)";
		private String pointStrokeColor = "#fff";
		private String pointHighlightFill = "#fff";
		private String pointHighlightStroke = "rgba(220,220,220,1)";
		private List<Double> data;

		/*
		 * public String getLabel() { return label; }
		 * 
		 * public void setLabel(String label) { this.label = label; }
		 */

		public String getFillColor() {
			return fillColor;
		}

		public void setFillColor(String fillColor) {
			this.fillColor = fillColor;
		}

		public String getStrokeColor() {
			return strokeColor;
		}

		public void setStrokeColor(String strokeColor) {
			this.strokeColor = strokeColor;
		}

		public String getPointColor() {
			return pointColor;
		}

		public void setPointColor(String pointColor) {
			this.pointColor = pointColor;
		}

		public String getPointStrokeColor() {
			return pointStrokeColor;
		}

		public void setPointStrokeColor(String pointStrokeColor) {
			this.pointStrokeColor = pointStrokeColor;
		}

		public String getPointHighlightFill() {
			return pointHighlightFill;
		}

		public void setPointHighlightFill(String pointHighlightFill) {
			this.pointHighlightFill = pointHighlightFill;
		}

		public String getPointHighlightStroke() {
			return pointHighlightStroke;
		}

		public void setPointHighlightStroke(String pointHighlightStroke) {
			this.pointHighlightStroke = pointHighlightStroke;
		}

		public List<Double> getData() {
			return data;
		}

		public void setData(List<Double> values) {
			this.data = values;
		}

		@Override
		public String toString() {
			return "DataSetVO [fillColor=" + fillColor + ", strokeColor=" + strokeColor + ", pointColor=" + pointColor + ", pointStrokeColor=" + pointStrokeColor
					+ ", pointHighlightFill=" + pointHighlightFill + ", pointHighlightStroke=" + pointHighlightStroke + ", data=" + data + "]";
		}

	}

	public LineChartDTO() {
		labels = new TreeSet<String>();
		datasets = new ArrayList<DataSetDTO>();
	}

	public Set<String> getLabels() {
		return labels;
	}

	public void setLabels(Set<String> set) {
		this.labels = set;
	}

	public List<DataSetDTO> getDatasets() {
		return datasets;
	}

	public void setDatasets(List<DataSetDTO> datasets) {
		this.datasets = datasets;
	}

	@Override
	public String toString() {
		return "CharDataVO [labels=" + labels + ", datasets=" + datasets + "]";
	}
}
