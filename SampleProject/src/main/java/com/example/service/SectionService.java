package com.example.service;

import java.util.List;

import com.example.model.Section;

public interface SectionService {
	Section save(Section section);
	
	Section findById(String sectionId);
	
	List<Section> save(List<Section> sectionList);

	void delete(Section section);

	Section findByEngineIdAndName(String engineId, String name);

	List<Section> findByEngineId(String engineId);

	public void setSectionProperties(Section section, String sectionName);
	
	List<Section> findAll();
}
