package edu.chart.hellograph.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipGraphRepository;

import edu.chart.hellograph.domain.World;

public interface WorldRepository extends GraphRepository<World>{
	
}
