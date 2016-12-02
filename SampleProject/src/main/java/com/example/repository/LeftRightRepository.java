package com.example.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.LeftRight;

public interface LeftRightRepository extends GraphRepository<LeftRight>{

	LeftRight findById(String id);
	
	List<LeftRight> findByLeftParentId(String id);
	
	List<LeftRight> findByLeftId(List<String> ids);
}
