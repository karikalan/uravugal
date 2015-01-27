package edu.chart.hellograph.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.support.index.IndexType;

import edu.chart.hellograph.dto.BaseClass;

import java.util.List;
import java.util.Set;

@NodeEntity
public class World {
	public final static String REACHABLE_BY_ROCKET = "REACHABLE_BY_ROCKET";

	// Uses default schema based index
	@Indexed
	private String label;
	
	@GraphId
	Long id;
	
	Long createdAt;

	// Uses legacy index mechanism
	@Indexed(indexType = IndexType.SIMPLE)
	private int moons;

	@Fetch
	@RelatedTo(type = REACHABLE_BY_ROCKET, direction = Direction.BOTH)
	@JsonIgnore
	private Set<World> reachableByRocket;

	public World(String name, int moons) {
		this.label = name;
		this.moons = moons;
	}

	public World() {
	}

	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public int getMoons() {
		return moons;
	}
	
	@JsonIgnore
	public Set<World> getReachableWorlds(){
		return reachableByRocket;
	}

	public void addRocketRouteTo(World otherWorld) {
		reachableByRocket.add(otherWorld);
	}

	@JsonIgnore
	public boolean canBeReachedFrom(World otherWorld) {
		return reachableByRocket.contains(otherWorld);
	}
	
	

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	
	

	@Override
	public int hashCode() {
		return (id == null) ? 0 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		World other = (World) obj;
		if (id == null)
			return other.id == null;
		return id.equals(other.id);
	}

	@Override
	public String toString() {
		return "World [label=" + label + ", id=" + id + ", createdAt=" + createdAt + ", moons=" + moons + "]";
	}

}
