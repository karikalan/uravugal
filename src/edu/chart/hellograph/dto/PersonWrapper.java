package edu.chart.hellograph.dto;

import java.util.List;

import edu.chart.hellograph.domain.World;

public class PersonWrapper implements java.io.Serializable{
	private List<World> testList;

	public List<World> getTestList() {
		return testList;
	}

	public void setTestList(List<World> testList) {
		this.testList = testList;
	}

	@Override
	public String toString() {
		return "PersonWrapper [testList=" + testList + "]";
	}

	
	
	
}
