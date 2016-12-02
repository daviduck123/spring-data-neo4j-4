package com.example.service;

import com.example.model.Left;

public interface LeftService {

	void save(Left left);
	
	Left findById(String id);
}
