package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Left;
import com.example.repository.LeftRepository;

@Service
@Transactional
public class LeftServiceImpl implements LeftService {

	@Autowired
	LeftRepository repository;
	
	public LeftServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Left left) {
		// TODO Auto-generated method stub
		if(left.getId() == null){
			left.setId(UUID.randomUUID().toString());
		}
		repository.save(left);
	}

	@Override
	public Left findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Left> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
