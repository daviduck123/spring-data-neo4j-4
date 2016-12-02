package com.example.service;

import java.util.List;

import com.example.model.LeftRight;

public interface LeftRightService {

	void save(LeftRight leftRight);

	LeftRight findById(String id);

	List<LeftRight> findByLeftParentId(String id);
	
	List<LeftRight> findByLeftId(List<String> ids);
}
