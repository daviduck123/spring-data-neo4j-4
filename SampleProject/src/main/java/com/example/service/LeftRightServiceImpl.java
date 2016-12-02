package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.LeftRight;
import com.example.repository.LeftRightRepository;
@Service
@Transactional
public class LeftRightServiceImpl implements LeftRightService {

	@Autowired
	LeftRightRepository repository;
	@Override
	public void save(LeftRight leftRight) {
		// TODO Auto-generated method stub
		if(leftRight.getId() == null){
			leftRight.setId(UUID.randomUUID().toString());
		}
		repository.save(leftRight);
	}

	@Override
	public List<LeftRight> findByLeftParentId(String id) {
		// TODO Auto-generated method stub
		return repository.findByLeftParentId(id);
	}

	@Override
	public LeftRight findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<LeftRight> findByLeftId(List<String> ids) {
		// TODO Auto-generated method stub
		return repository.findByLeftId(ids);
	}

}
