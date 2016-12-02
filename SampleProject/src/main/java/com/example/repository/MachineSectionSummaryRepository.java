package com.example.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.MachineSectionSummary;


public interface MachineSectionSummaryRepository extends GraphRepository<MachineSectionSummary> {
	MachineSectionSummary findByMachineNameAndSectionGroupAndCategory(String machineName, String sectionGroup, String category);

	List<MachineSectionSummary> findByMachineId(String machineId);
}
