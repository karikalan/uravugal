package edu.chart.hellograph.dto;

public class BaseClass {
	String x;
	String y;
	String allowedToMoveX;
	String allowedToMoveY;
	Long id;
	Long createdAt;
	String label;
	int moons;
	
	
	
	public Long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getAllowedToMoveX() {
		return allowedToMoveX;
	}
	public void setAllowedToMoveX(String allowedToMoveX) {
		this.allowedToMoveX = allowedToMoveX;
	}
	public String getAllowedToMoveY() {
		return allowedToMoveY;
	}
	public void setAllowedToMoveY(String allowedToMoveY) {
		this.allowedToMoveY = allowedToMoveY;
	}
	
	
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getMoons() {
		return moons;
	}
	public void setMoons(int moons) {
		this.moons = moons;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		return "BaseClass [x=" + x + ", y=" + y + ", allowedToMoveX=" + allowedToMoveX + ", allowedToMoveY=" + allowedToMoveY + ", id=" + id + ", createdAt=" + createdAt
				+ ", label=" + label + ", moons=" + moons + "]";
	}
	
	
	
	
}
