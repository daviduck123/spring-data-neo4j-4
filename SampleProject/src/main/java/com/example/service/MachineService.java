package com.example.service;

import java.util.List;

import com.example.model.Machine;

public interface MachineService {
	Machine save(Machine machine);

	void delete(Machine machine);

	List<Machine> findAll();

	Machine findByName(String name);

	Machine findById(String id);

	void updateTotalDurationDepth(String id);

	void updateMachineSectionSummary(String id);
}
