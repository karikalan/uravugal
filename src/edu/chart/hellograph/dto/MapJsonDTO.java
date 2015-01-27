package edu.chart.hellograph.dto;

import java.util.ArrayList;
import java.util.List;

import edu.chart.hellograph.domain.Relations;
import edu.chart.hellograph.domain.World;

public class MapJsonDTO {
	private List<World> nodes;
	private List<Relations> edges;

	public MapJsonDTO() {
		nodes = new ArrayList<World>();
		edges = new ArrayList<Relations>();
	}

	public List<World> getNodes() {
		return nodes;
	}

	public List<Relations> getEdges() {
		return edges;
	}

}
