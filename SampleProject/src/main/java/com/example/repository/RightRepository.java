package com.example.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.Right;

public interface RightRepository extends GraphRepository<Right>{

	Right findById(String id);
}
