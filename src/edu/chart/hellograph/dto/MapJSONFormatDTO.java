package edu.chart.hellograph.dto;

public class MapJSONFormatDTO {
	private String jsonStrNode;
	private String jsonStrEdge;
	
	
	public MapJSONFormatDTO(String jsonStrNode, String jsonStrEdge) {
		super();
		this.jsonStrNode = jsonStrNode;
		this.jsonStrEdge = jsonStrEdge;
	}
	public MapJSONFormatDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getJsonStrNode() {
		return jsonStrNode;
	}
	public void setJsonStrNode(String jsonStrNode) {
		this.jsonStrNode = jsonStrNode;
	}
	public String getJsonStrEdge() {
		return jsonStrEdge;
	}
	public void setJsonStrEdge(String jsonStrEdge) {
		this.jsonStrEdge = jsonStrEdge;
	}
	
	
}
