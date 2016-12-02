package com.example.service;

import com.example.model.Right;

public interface RightService {

	void save(Right right);

	Right findById(String id);
}
