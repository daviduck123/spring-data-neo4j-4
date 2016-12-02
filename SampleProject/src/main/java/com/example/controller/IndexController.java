package com.example.controller;

import java.util.List;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Unit;
import com.example.service.InitializationService;
import com.example.service.UnitService;

@Controller
public class IndexController {
	@Autowired
	private InitializationService initializationService;

	@Autowired
	private UnitService unitService;

	@Autowired
	Flyway flyway;

	@RequestMapping("/")
	public String index(Model model) {
		return "left-right";
	}

	@RequestMapping(value = "/initData")
	public ModelAndView initData() {
		initializationService.initData();
		ModelAndView model = new ModelAndView("redirect:/");
		return model;
	}
	
	@RequestMapping(value = "/initMachineSectionSummary")
	public ModelAndView initMachineSectionSummary() {
		initializationService.initMachineSectionSummary5OffsetMachine();
		ModelAndView model = new ModelAndView("redirect:/");
		return model;
	}
	
	@RequestMapping(value = "/initUnit")
	public ModelAndView initUnit() {
		initializationService.initUnit();

		ModelAndView model = new ModelAndView("redirect:/");
		return model;
	}
	@RequestMapping(value = "/getUnit")
	public @ResponseBody List<Unit> getUnit() {
		flyway.migrate();
		return unitService.findAllByQuery();
	}
}