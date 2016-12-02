package com.example.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.ParentClass;

public interface ParentClassRepository extends GraphRepository<ParentClass> {

	ParentClass findById(String id);
}
