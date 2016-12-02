package com.example.service;

import java.util.List;

import com.example.model.Left;

public interface LeftService {

	void save(Left left);
	
	Left findById(String id);
	
	List<Left> findAll();
}
