
package com.example.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.example.model.Engine;

public interface EngineRepository extends GraphRepository<Engine> {
	Engine findById(String id);

	List<Engine> findByMachineId(String machineId);

	Engine findByMachineIdAndName(String machineId, String name);

	Engine findByMachineNameAndName(String machineName, String name);

	List<Engine> findAllByActive(Boolean active);

	List<Engine> findAllByLineEngineInactive(Boolean lineEngineInactive);
}
