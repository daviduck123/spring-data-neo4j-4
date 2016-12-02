package com.example.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.Left;


public interface LeftRepository extends GraphRepository<Left> {

	Left findById(String id);
	
	List<Left> findAll();
}
