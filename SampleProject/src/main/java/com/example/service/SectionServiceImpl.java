package com.example.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Section;
import com.example.repository.SectionRepository;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {

	@Autowired
	SectionRepository sectionRepository;

	@Override
	@Transactional
	public Section save(Section section) {
		if (section.getId() == null) {
			section.setId(UUID.randomUUID().toString());
		}
		section = sectionRepository.save(section);
		return section;
	}
	
	@Override
	@Transactional
	public List<Section> save(List<Section> sectionList) {
		for (Section section : sectionList) {
			if (section.getId() == null) {
				section.setId(UUID.randomUUID().toString());
			}
		}
		sectionList = (List<Section>) sectionRepository.save(sectionList);
		return sectionList;
	}

	@Override
	@Transactional
	public void delete(Section section) {
		sectionRepository.delete(section);
	}

	@Override
	public Section findByEngineIdAndName(String engineId, String name) {
		return sectionRepository.findByEngineIdAndName(engineId, name);
	}

	@Override
	public List<Section> findByEngineId(String engineId) {
		return sectionRepository.findByEngineId(engineId);
	}

	@Override
	public void setSectionProperties(Section section, String sectionName) {
		section.setName(sectionName);
		sectionName = sectionName.toLowerCase();

		if (sectionName.contains("miru")) {
			section.setGroup("MIRU");
		} else if (sectionName.contains("perforation") || sectionName.contains("lower completion") || sectionName.contains("x-mas tree")
				|| sectionName.contains("upper completion") || sectionName.contains("stimulation")) {
			section.setGroup("Completion");
		} else {
			section.setGroup("Drilling");
		}

		//kalo di section itu ada code 3/4 --> drilling
		//kalo ada 23/23a/23b --> casing
		boolean isHoleSizeSection = false;
		boolean isCasingSizeSection = false;
		if (sectionName.contains("drilling")) {
			isHoleSizeSection = true;
		}
		if (sectionName.contains("casing") || sectionName.contains("liner") || sectionName.contains("conductor")) {
			isCasingSizeSection = true;
		}
		String[] arrSplit = sectionName.trim().split(" ");
		for (String strSplit : arrSplit) {
			strSplit = strSplit.replace("\"", "");
			if (StringUtils.isNumeric(strSplit.replace(".", ""))) {
				if (isHoleSizeSection && section.getHoleSize() == null) {
					section.setHoleSize(strSplit);
				}
				if (isCasingSizeSection && section.getCasingSize() == null) {
					section.setCasingSize(strSplit);
				}
			}
		}
	}
	
	@Override
	public List<Section> findAll() {
		return sectionRepository.findAll();
	}

	@Override
	public Section findById(String sectionId) {
		// TODO Auto-generated method stub
		return sectionRepository.findById(sectionId);
	}
}