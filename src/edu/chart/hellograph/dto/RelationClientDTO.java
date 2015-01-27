package edu.chart.hellograph.dto;

public class RelationClientDTO {
	private long from;
	private long to;
	private String label;
	private String action;
	private long id;
	public long getFrom() {
		return from;
	}
	public void setFrom(long from) {
		this.from = from;
	}
	public long getTo() {
		return to;
	}
	public void setTo(long to) {
		this.to = to;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "RelationClientDTO [from=" + from + ", to=" + to + ", label=" + label + ", action=" + action + ", id=" + id + "]";
	}
	
}
