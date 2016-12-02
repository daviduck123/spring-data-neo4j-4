package com.example.service;

import com.example.model.ParentClass;

public interface ParentClassService {

	void save(ParentClass class1);

	ParentClass findById(String id);
}
