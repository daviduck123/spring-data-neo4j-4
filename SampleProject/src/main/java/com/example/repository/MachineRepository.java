package com.example.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.Machine;


public interface MachineRepository extends GraphRepository<Machine> {
	List<Machine> findAll();

	Machine findByName(String name);
	
	Machine findById(String id);
}
