package com.example.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.Unit;


public interface UnitRepository extends GraphRepository<Unit> {

	@Query("MATCH (n:Unit) RETURN n")
	List<Unit> findAllByQuery();

	Unit findByName(String name);

	Unit findByCode(String code);
}
