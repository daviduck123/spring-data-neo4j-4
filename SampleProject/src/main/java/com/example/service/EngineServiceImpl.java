
package com.example.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Engine;
import com.example.repository.EngineRepository;


@Service
@Transactional
public class EngineServiceImpl implements EngineService {

	@Autowired
	EngineRepository engineRepository;

	@Override
	@Transactional
	public Engine save(Engine engine) {
		if (engine.getId() == null) {
			engine.setId(UUID.randomUUID().toString());
		}
		engine.setLastModified(new Date());
		engine = engineRepository.save(engine);
		return engine;
	}

	@Override
	@Transactional
	public void delete(Engine engine) {
		engineRepository.delete(engine);
	}

	@Override
	public Engine findById(String id) {
		return engineRepository.findById(id);
	}

	@Override
	public List<Engine> findByMachineId(String machineId) {
		return engineRepository.findByMachineId(machineId);
	}

	@Override
	public Engine findByMachineIdAndName(String machineId, String name) {
		return engineRepository.findByMachineIdAndName(machineId, name);
	}

	@Override
	public Engine findByMachineNameAndName(String machineName, String name) {
		return engineRepository.findByMachineNameAndName(machineName, name);
	}

	@Override
	public List<Engine> findAllByActive(Boolean active) {
		return engineRepository.findAllByActive(active);
	}

	@Override
	public List<Engine> findAllByLineEngineInactive(Boolean lineEngineInactive) {
		return engineRepository.findAllByLineEngineInactive(lineEngineInactive);
	}
}