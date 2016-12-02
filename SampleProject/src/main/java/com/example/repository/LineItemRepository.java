package com.example.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.LineItem;

public interface LineItemRepository extends GraphRepository<LineItem> {
	List<LineItem> findAll();
	
	LineItem findById(String id);
	
	List<LineItem> findByEngineIdOrderByNoAsc(String engineId);
	
	List<LineItem> findByEngineIdAndActivityTypeOrderByNoAsc(String engineId, String activityType);

	LineItem findByIdAndEngineId(String lineItemId, String engineId);
	
	List<LineItem> findByEngineIdAndNoGreaterThan(String engineId, Integer no);
	
	List<LineItem> findBySectionIdOrderByNoAsc(String sectionId);
}