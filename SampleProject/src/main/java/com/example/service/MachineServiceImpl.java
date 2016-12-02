package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Engine;
import com.example.model.LineItem;
import com.example.model.Machine;
import com.example.model.MachineSectionSummary;
import com.example.repository.MachineRepository;

@Service
@Transactional
public class MachineServiceImpl implements MachineService {

	@Autowired
	MachineRepository machineRepository;

	@Autowired
	EngineService engineService;

	@Autowired
	LineItemService lineItemService;

	@Autowired
	MachineSectionSummaryService machineSectionSummaryService;

	@Override
	@Transactional
	public Machine save(Machine machine) {
		if (machine.getId() == null) {
			machine.setId(UUID.randomUUID().toString());
		}
		machine = machineRepository.save(machine);
		return machine;
	}

	@Override
	@Transactional
	public void delete(Machine machine) {
		machineRepository.delete(machine);
	}

	@Override
	public List<Machine> findAll() {
		return machineRepository.findAll();
	}

	@Override
	public Machine findByName(String name) {
		return machineRepository.findByName(name);
	}

	@Override
	public Machine findById(String id) {
		return machineRepository.findById(id);
	}

	@Override
	public void updateTotalDurationDepth(String id) {
		Machine machine = machineRepository.findById(id);
		if (machine != null) {
			Engine engine = engineService.findByMachineIdAndName(machine.getId(), "Train");
			if (engine != null) {
				List<LineItem> lineItems = lineItemService.findByEngineIdOrderByNoAsc(engine.getId());
				Double totalDuration = 0.0, totalDepth = 0.0;
				for (LineItem lineItem : lineItems) {
					totalDuration += lineItem.getDuration();
					if (lineItem.getPlannedMD() != null && lineItem.getPlannedMD() > 0) {
						if (totalDepth < lineItem.getPlannedMD()) {
							totalDepth = lineItem.getPlannedMD();
						}
					}
				}
				machine.setDuration(roundUpToNearestQuarter(totalDuration/ 24));
				machineRepository.save(machine);
			}
		}
	}

	@Override
	public void updateMachineSectionSummary(String id) {
		Machine currentMachine = findById(id);
		if (currentMachine == null) {
			return;
		}
		Engine currentEngine = engineService.findByMachineIdAndName(currentMachine.getId(), "Train");
		if (currentEngine == null) {
			return;
		}
		List<LineItem> currentLineItemList = lineItemService.findByEngineIdAndActivityTypeOrderByNoAsc(currentEngine.getId(), "P");

		List<Engine> offsetEngineList = new ArrayList<Engine>();
		List<List<LineItem>> offsetLineItemList = new ArrayList<List<LineItem>>();
		offsetEngineList.add(engineService.findByMachineNameAndName("MX-01", "Train"));
		offsetEngineList.add(engineService.findByMachineNameAndName("MX-02", "Train"));
		offsetEngineList.add(engineService.findByMachineNameAndName("MX-03", "Train"));
		offsetEngineList.add(engineService.findByMachineNameAndName("MX-04", "Train"));
		offsetEngineList.add(engineService.findByMachineNameAndName("MX-05", "Train"));
		for (Engine engine : offsetEngineList) {
			List<LineItem> lineItemList = lineItemService.findByEngineIdAndActivityTypeOrderByNoAsc(engine.getId(), "P");
			offsetLineItemList.add(lineItemList);
		}

		for (int i = 0; i < currentLineItemList.size(); i++) {
			LineItem currentLineItem = currentLineItemList.get(i);
			List<Double> durationList = new ArrayList<Double>();
			for (List<LineItem> lineItemList : offsetLineItemList) {
				if(i < lineItemList.size())
					durationList.add(lineItemList.get(i).getDuration());
			}

			Double bestDuration = durationList.stream().mapToDouble(d -> d).min().getAsDouble(); // Get minimum duration offset machines
			currentLineItem.setDurationInefficiency(currentLineItem.getDuration() - bestDuration);
		}

		List<String> sectionGroupList = new ArrayList<String>();
		sectionGroupList.add("PART-X");
		sectionGroupList.add("CHAIN-06");
		sectionGroupList.add("BTM-01");
		sectionGroupList.add("Other");
		for (String sectionGroup : sectionGroupList) {
			Double durationTotal = currentLineItemList.stream().filter(d -> d.getSection().getGroup().equalsIgnoreCase(sectionGroup))
					.mapToDouble(LineItem::getDuration).sum();
			durationTotal = durationTotal / 24;
			Double percentDurationTotal = (durationTotal / durationTotal) * 100.0;

			Double durationInefficiency = currentLineItemList.stream().filter(d -> d.getSection().getGroup().equalsIgnoreCase(sectionGroup))
					.mapToDouble(LineItem::getDurationInefficiency).sum();
			durationInefficiency = durationInefficiency / 24;

			MachineSectionSummary currentWSSTotal = machineSectionSummaryService.findByMachineNameAndSectionGroupAndCategory(currentMachine.getName(),
					sectionGroup, "Total");
			if (currentWSSTotal != null) {
				currentWSSTotal.setDuration(durationTotal);
				currentWSSTotal.setPercentDuration(percentDurationTotal);
				machineSectionSummaryService.save(currentWSSTotal);
			}
		}
	}
	public double roundUpToNearestQuarter(double input) {
		double result = Math.ceil(input * 4) / 4;
		return result;
	}
}