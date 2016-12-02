package com.example.service;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.ParentClass;
import com.example.repository.ParentClassRepository;

@Service
@Transactional
public class ParentClassServiceImpl implements ParentClassService {

	@Autowired
	ParentClassRepository repository;

	@Override
	public void save(ParentClass class1) {
		// TODO Auto-generated method stub
		if(class1.getId() == null){
			class1.setId(UUID.randomUUID().toString());
		}
		repository.save(class1);
	}

	@Override
	public ParentClass findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
