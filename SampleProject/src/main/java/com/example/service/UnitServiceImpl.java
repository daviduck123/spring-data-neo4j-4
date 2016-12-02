package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Unit;
import com.example.repository.UnitRepository;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {

	@Autowired
	UnitRepository unitRepository;

	@Override
	@Transactional
	public Unit save(Unit unit) {
		if (unit.getId() == null) {
			unit.setId(UUID.randomUUID().toString());
		}
		unit = unitRepository.save(unit);
		return unit;
	}

	@Override
	@Transactional
	public void delete(Unit unit) {
		unitRepository.delete(unit);
	}

	@Override
	public List<Unit> findAllByQuery() {
		return unitRepository.findAllByQuery();
	}

	@Override
	public Unit findByName(String name) {
		return unitRepository.findByName(name);
	}

	@Override
	public Unit findByCode(String code) {
		return unitRepository.findByCode(code);
	}

	@Override
	public Integer Calc(Integer a, Integer b) {
		if (a + b < 10) {
			return a + b;
		}
		return 0;
	}
}