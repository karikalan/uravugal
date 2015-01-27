package edu.chart.demo.vo;

import java.util.Arrays;

public class DataSetVO {

	//private String label;
	private String fillColor = "rgba(220,220,220,0.2)";
	private String strokeColor = "rgba(220,220,220,1)";
	private String pointColor = "rgba(220,220,220,1)";
	private String pointStrokeColor = "#fff";
	private String pointHighlightFill = "#fff";
	private String pointHighlightStroke = "rgba(220,220,220,1)";
	private int[] data;

	/*public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}*/

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

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DataSetVO [fillColor=" + fillColor + ", strokeColor="
				+ strokeColor + ", pointColor=" + pointColor
				+ ", pointStrokeColor=" + pointStrokeColor
				+ ", pointHighlightFill=" + pointHighlightFill
				+ ", pointHighlightStroke=" + pointHighlightStroke + ", data="
				+ Arrays.toString(data) + "]";
	}
	
	

}
