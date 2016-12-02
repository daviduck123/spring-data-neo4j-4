package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Left;
import com.example.model.LeftRight;
import com.example.model.ParentClass;
import com.example.model.Right;
import com.example.service.LeftRightService;
import com.example.service.LeftService;
import com.example.service.ParentClassService;
import com.example.service.RightService;

@Controller
public class LeftRightController {

	@Autowired
	LeftRightService leftRightService;

	@Autowired
	RightService rightService;

	@Autowired
	LeftService leftService;

	@Autowired
	ParentClassService parentClassService;

	public LeftRightController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/leftRight")
	public @ResponseBody List<LeftRight> getListLeftRightByParentId() {
		// to make it easier, I will save new data with relationship and get it
		Right right = new Right("Right");
		rightService.save(right);

		ParentClass parentClass = new ParentClass("Parent Left");
		parentClassService.save(parentClass);

		//I already create Parent Class and then I put it on Left Class
		Left left = new Left("Left", parentClass);
		leftService.save(left);

		//Left Class should be have ParentClass already
		LeftRight leftRight = new LeftRight(left, right);
		leftRightService.save(leftRight);

		//return empty list
		List<LeftRight> list = leftRightService.findByLeftParentId(parentClass.getId());
		return list;

	}

}
