package com.example.service;

import java.util.List;

import com.example.model.Engine;

public interface EngineService {
	Engine save(Engine Engine);

	void delete(Engine Engine);

	Engine findById(String id);

	List<Engine> findByMachineId(String machineId);

	Engine findByMachineIdAndName(String machineId, String name);

	Engine findByMachineNameAndName(String machineName, String name);

	List<Engine> findAllByActive(Boolean active);

	List<Engine> findAllByLineEngineInactive(Boolean lineEngineInactive);
}
