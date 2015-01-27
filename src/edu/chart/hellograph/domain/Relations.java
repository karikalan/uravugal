package edu.chart.hellograph.domain;

public class Relations {
	private Long from;
	private Long to;
	private Long id;
	private String label;

	public Long getFrom() {
		return from;
	}

	public void setFrom(Long from) {
		this.from = from;
	}

	public Long getTo() {
		return to;
	}

	public void setTo(Long to) {
		this.to = to;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Relations [from=" + from + ", to=" + to + ", id=" + id + ", label=" + label + "]";
	}

}
