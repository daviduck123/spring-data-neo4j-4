package com.example.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.Section;


public interface SectionRepository extends GraphRepository<Section> {
	Section findByEngineIdAndName(String engineId, String name);

	List<Section> findByEngineId(String engineId);
	
	List<Section> findAll();
	
	Section findById(String sectionId);
}
