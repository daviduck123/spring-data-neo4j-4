package com.example.service;

import java.util.List;

import com.example.model.MachineSectionSummary;

public interface MachineSectionSummaryService {
	MachineSectionSummary save(MachineSectionSummary machineSectionSummary);

	void delete(MachineSectionSummary machineSectionSummary);

	void delete(List<MachineSectionSummary> machineSectionSummaryList);

	MachineSectionSummary findByMachineNameAndSectionGroupAndCategory(String machineName, String sectionGroup, String category);

	List<MachineSectionSummary> findByMachineId(String machineId);
}
