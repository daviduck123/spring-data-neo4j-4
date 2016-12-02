package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Right;
import com.example.repository.RightRepository;

@Service
@Transactional
public class RightServiceImpl  implements RightService{
	@Autowired
	RightRepository repository;
	public RightServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Right right) {
		// TODO Auto-generated method stub
		if(right.getId() == null){
			right.setId(UUID.randomUUID().toString());
		}
		repository.save(right);
	}

	@Override
	public Right findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
