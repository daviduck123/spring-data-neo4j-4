package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.MachineSectionSummary;
import com.example.repository.MachineSectionSummaryRepository;
@Service
@Transactional
public class MachineSectionSummaryServiceImpl implements MachineSectionSummaryService {

	@Autowired
	MachineSectionSummaryRepository machineSectionSummaryRepository;

	@Override
	@Transactional
	public MachineSectionSummary save(MachineSectionSummary machineSectionSummary) {
		if (machineSectionSummary.getId() == null) {
			machineSectionSummary.setId(UUID.randomUUID().toString());
		}
		machineSectionSummary = machineSectionSummaryRepository.save(machineSectionSummary);
		return machineSectionSummary;
	}

	@Override
	@Transactional
	public void delete(MachineSectionSummary machineSectionSummary) {
		machineSectionSummaryRepository.delete(machineSectionSummary);
	}

	@Override
	@Transactional
	public void delete(List<MachineSectionSummary> machineSectionSummaryList) {
		machineSectionSummaryRepository.delete(machineSectionSummaryList);
	}

	@Override
	public MachineSectionSummary findByMachineNameAndSectionGroupAndCategory(String machineName, String sectionGroup, String category) {
		return machineSectionSummaryRepository.findByMachineNameAndSectionGroupAndCategory(machineName, sectionGroup, category);
	}

	@Override
	public List<MachineSectionSummary> findByMachineId(String machineId) {
		return machineSectionSummaryRepository.findByMachineId(machineId);
	}
}