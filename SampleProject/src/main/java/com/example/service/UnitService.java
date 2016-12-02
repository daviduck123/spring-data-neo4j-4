package com.example.service;

import java.util.List;

import com.example.model.Unit;

public interface UnitService {
	Unit save(Unit unit);

	void delete(Unit unit);

	List<Unit> findAllByQuery();

	Unit findByName(String name);

	Unit findByCode(String code);

	Integer Calc(Integer a, Integer b);
}
