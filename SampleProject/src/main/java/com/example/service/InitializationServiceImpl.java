package com.example.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Enum;
import com.example.initialData.*;
import com.example.model.Currency;
import com.example.model.Engine;
import com.example.model.LineItem;
import com.example.model.Machine;
import com.example.model.MachineSectionSummary;
import com.example.model.Section;
import com.example.model.Unit;

@Service
@Transactional
public class InitializationServiceImpl implements InitializationService {
	
	@Autowired
	MachineService machineService;
	
	@Autowired
	UnitService unitService;
	
	@Autowired
	CurrencyService currencyService;
	
	@Autowired
	SectionService sectionService;

	@Autowired
	MachineSectionSummaryService machineSectionSummaryService;
	
	@Autowired
	EngineService engineService;
	
	@Autowired
	LineItemService lineItemService;
	
	private String[][] unitList = {
			{ "ft", "Feet", "3.28084" },
			{ "m", "Metre", "1" },
			{ "inch", "Inch", "39.3701" },
			{ "mm", "millimetre", "1000" },
			{ "ft/hr", "Feet/Hours", "3.28084" },
			{ "m/hr", "Metre/Hours", "1" },
			{ "hrs", "Hours", "24" },
			{ "days", "Days", "1"}
	};
	
	private String[][] currencyList = {
			{ "USD", "7.5" },
			{ "DKK", "1" }
	};
	
	
	private String[][] machineList = {
			{ "KTX-01", "MRX", "8371", "m", "06-08-2005", "03-05-2006", "270", "20300000" }, 
			{ "KTX-02", "MRX", "8390", "m", "03-05-2006", "27-07-2006", "85", "12000000" }, 
			{ "KTX-03", "MRX", "8692", "m", "27-07-2006", "09-12-2006", "135", "15700000" }, 
			{ "MA-01", "MRX", "4092", "m", "20-12-2006", "19-02-2007", "61", "13500000" }, 
			{ "MA-02", "MRX", "8269", "m", "14-04-2005", "16-10-2005", "185", "19900000" }, 
			{ "MA-03", "MRX", "3454", "m", "21-12-2011", "28-12-2012", "373", "35300000" }, 
			{ "MA-04", "LOKPO", "8096", "m", "08-02-2012", "14-07-2012", "157", "21100000" }, 
			{ "MA-05", "MRX", "5506", "m", "14-02-2010", "27-10-2010", "255", "25300000" }, 
			{ "MX-01", "MRX", "6768", "m", "29-09-2003", "24-03-2004", "177", "7100000" }, 
			{ "MX-02", "LOKPO", "7621", "m", "14-07-2012", "07-06-2013", "328", "10500000" }, 
			{ "MX-03", "MRX", "2535", "m", "09-01-1983", "19-04-1983", "100", "2100000" }, 
			{ "MX-04", "MRX", "2672", "m", "10-12-1982", "19-04-1983", "130", "1900000" }, 
			{ "MX-05", "MRX", "2186", "m", "26-09-1982", "16-04-1983", "202", "2500000" }
	};
	
	private String[][] machineSectionSummaryList = {
			{ "MX-01", "PART-X", "Total", "0", "0", "583000", "", "USD" },
			{ "MX-01", "CHAIN-06", "Total", "0", "0", "3500234", "", "USD" },
			{ "MX-01", "BTM-01", "Total", "0", "0", "2754390", "", "USD" },
			{ "MX-01", "Other", "Total", "0", "0", "302930", "", "USD" },
			{ "MX-01", "PART-X", "Inefficiency", "0", "0", "", "", "USD" },
			{ "MX-01", "CHAIN-06", "Inefficiency", "0", "0", "553230", "16", "USD" },
			{ "MX-01", "BTM-01", "Inefficiency", "0", "0", "234500", "9", "USD" },
			{ "MX-01", "Other", "Inefficiency", "0", "0", "", "", "USD" },
			{ "MX-01", "PART-X", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-01", "CHAIN-06", "Non Productive", "0", "0", "335000", "10", "USD" },
			{ "MX-01", "BTM-01", "Non Productive", "0", "0", "150300", "5", "USD" },
			{ "MX-01", "Other", "Non Productive", "0", "0", "53000", "17", "USD" },
			{ "MX-02", "PART-X", "Total", "0", "0", "883290", "", "USD" },
			{ "MX-02", "CHAIN-06", "Total", "0", "0", "4300230", "", "USD" },
			{ "MX-02", "BTM-01", "Total", "0", "0", "5230494", "", "USD" },
			{ "MX-02", "Other", "Total", "0", "0", "123048", "", "USD" },
			{ "MX-02", "PART-X", "Inefficiency", "0", "0", "", "", "USD" },
			{ "MX-02", "CHAIN-06", "Inefficiency", "0", "0", "365049", "8", "USD" },
			{ "MX-02", "BTM-01", "Inefficiency", "0", "0", "743982", "14", "USD" },
			{ "MX-02", "Other", "Inefficiency", "0", "0", "", "", "USD" },
			{ "MX-02", "PART-X", "Non Productive", "0", "0", "300290", "34", "USD" },
			{ "MX-02", "CHAIN-06", "Non Productive", "0", "0", "1420394", "33", "USD" },
			{ "MX-02", "BTM-01", "Non Productive", "0", "0", "2304847", "44", "USD" },
			{ "MX-02", "Other", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-03", "PART-X", "Total", "0", "0", "", "", "USD" },
			{ "MX-03", "CHAIN-06", "Total", "0", "0", "2053948", "", "USD" },
			{ "MX-03", "BTM-01", "Total", "0", "0", "210394", "", "USD" },
			{ "MX-03", "Other", "Total", "0", "0", "54029", "", "USD" },
			{ "MX-03", "PART-X", "Inefficiency", "0", "0", "", "", "USD" },
			{ "MX-03", "CHAIN-06", "Inefficiency", "0", "0", "304930", "15", "USD" },
			{ "MX-03", "BTM-01", "Inefficiency", "0", "0", "52039", "25", "USD" },
			{ "MX-03", "Other", "Inefficiency", "0", "0", "10293", "19", "USD" },
			{ "MX-03", "PART-X", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-03", "CHAIN-06", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-03", "BTM-01", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-03", "Other", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-04", "PART-X", "Total", "0", "0", "", "", "USD" },
			{ "MX-04", "CHAIN-06", "Total", "0", "0", "2053948", "", "USD" },
			{ "MX-04", "BTM-01", "Total", "0", "0", "210394", "", "USD" },
			{ "MX-04", "Other", "Total", "0", "0", "54029", "", "USD" },
			{ "MX-04", "PART-X", "Inefficiency", "0", "0", "", "", "USD" },
			{ "MX-04", "CHAIN-06", "Inefficiency", "0", "0", "304930", "15", "USD" },
			{ "MX-04", "BTM-01", "Inefficiency", "0", "0", "52039", "25", "USD" },
			{ "MX-04", "Other", "Inefficiency", "0", "0", "10293", "19", "USD" },
			{ "MX-04", "PART-X", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-04", "CHAIN-06", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-04", "BTM-01", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-04", "Other", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-05", "PART-X", "Total", "0", "0", "", "", "USD" },
			{ "MX-05", "CHAIN-06", "Total", "0", "0", "2053948", "", "USD" },
			{ "MX-05", "BTM-01", "Total", "0", "0", "210394", "", "USD" },
			{ "MX-05", "Other", "Total", "0", "0", "54029", "", "USD" },
			{ "MX-05", "PART-X", "Inefficiency", "0", "0", "", "", "USD" },
			{ "MX-05", "CHAIN-06", "Inefficiency", "0", "0", "304930", "15", "USD" },
			{ "MX-05", "BTM-01", "Inefficiency", "0", "0", "52039", "25", "USD" },
			{ "MX-05", "Other", "Inefficiency", "0", "0", "10293", "19", "USD" },
			{ "MX-05", "PART-X", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-05", "CHAIN-06", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-05", "BTM-01", "Non Productive", "0", "0", "", "", "USD" },
			{ "MX-05", "Other", "Non Productive", "0", "0", "", "", "USD" },
	};
	
	private String[][] engineList = {
			{ "MX-01", "Train" },
			{ "MX-02", "Train" },
			{ "MX-03", "Train" },
			{ "MX-04", "Train" },
			{ "MX-05", "Train" }
	};

	@Override
	public void initData() {
		initUnit();
		initCurrency();
		initMachine();
		initMachineSectionSummary();
		initEngine();
		initLineItem();
		initMachineSectionSummary5OffsetMachine();
	}

	@Override
	public void initUnit() {
		for (String[] unit : unitList) {
			Unit existUnit = unitService.findByName(unit[1]);

			if (existUnit == null) {
				existUnit = new Unit(unit[0], unit[1], Double.valueOf(unit[2]));
				unitService.save(existUnit);
			}
		}
	}

	@Override
	public void initCurrency() {
		for (String[] currency : currencyList) {
			Currency existCurrency = currencyService.findByName(currency[0]);

			if (existCurrency == null) {
				existCurrency = new Currency(currency[0], Double.valueOf(currency[1]));
				currencyService.save(existCurrency);
			}
		}
	}

	@Override
	@Transactional
	public void initMachine() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		for (String[] machine : machineList) {
			Machine machineExist = machineService.findByName(machine[0]);
			if (machineExist == null) {
				Unit depthUnit = unitService.findByCode(machine[3]);
				Date startDate = null;
				try {
					startDate = sdf.parse(machine[4]);
				} catch (Exception e) {
				}
				Date endDate = null;
				try {
					endDate = sdf.parse(machine[5]);
				} catch (Exception e) {
				}
				Machine newMachine = new Machine(machine[0], "", Double.valueOf(machine[2]), depthUnit, startDate, endDate, Double.valueOf(machine[6]),
						Double.valueOf(machine[7]));
				Unit durationUnit = unitService.findByCode("days");
				newMachine.setDurationUnit(durationUnit);
				machineService.save(newMachine);
			}
		}
	}

	@Override
	public void initMachineSectionSummary() {
		for (String[] machineSectionSummary : machineSectionSummaryList) {
			Machine currentMachine = machineService.findByName(machineSectionSummary[0]);
			MachineSectionSummary currentMachineSectionSummary = machineSectionSummaryService
					.findByMachineNameAndSectionGroupAndCategory(currentMachine.getName(), machineSectionSummary[1], machineSectionSummary[2]);
			if (currentMachineSectionSummary == null && currentMachine != null) {
				Currency currentCurrency = currencyService.findByName(machineSectionSummary[7]);
				currentMachineSectionSummary = new MachineSectionSummary(currentMachine, machineSectionSummary[1], machineSectionSummary[2],
						(machineSectionSummary[3] != "" ? Double.valueOf(machineSectionSummary[3]) : null),
						(machineSectionSummary[4] != "" ? Double.valueOf(machineSectionSummary[4]) : null),
						(machineSectionSummary[5] != "" ? Double.valueOf(machineSectionSummary[5]) : null),
						(machineSectionSummary[6] != "" ? Double.valueOf(machineSectionSummary[6]) : null), currentCurrency);
				machineSectionSummaryService.save(currentMachineSectionSummary);
			}
		}
	}

	@Override
	public void initEngine() {
		for (String[] engine : engineList) {
			Engine existEngine = engineService.findByMachineNameAndName(engine[0], engine[1]);
			if (existEngine == null) {
				Machine machine = machineService.findByName(engine[0]);
				existEngine = new Engine(machine, engine[1]);
				engineService.save(existEngine);
			}
		}
	}

	@Override
	public void initLineItem() {
		List<String> machineNameList = new ArrayList<String>();
		machineNameList.add("MX-02");
		machineNameList.add("MX-01");
		machineNameList.add("MX-03");
		machineNameList.add("MX-04");
		machineNameList.add("MX-05");
		
		List<Double[]> checkSize = new ArrayList<Double[]>();
		Double[] casingSize = new Double[]{ 24.0, 18.625, 13.375, 10.75, 0.0, 7.0, 0.0};
		checkSize.add(casingSize);
		casingSize = new Double[]{ 24.0, 0.0, 0.0, 9.625, 0.0, 7.0, 4.0} ;
		checkSize.add(casingSize);
		casingSize = new Double[]{ 24.0, 18.625, 14.0, 10.75, 8.625, 7.0, 4.5} ;
		checkSize.add(casingSize);
		casingSize = new Double[]{ 26.0, 0.0, 0.0, 9.625, 0.0, 7.5, 0.0} ;
		checkSize.add(casingSize);
		casingSize = new Double[]{ 20.0, 0.0, 14.0, 10.75, 8.625, 7.0, 0.0} ;
		checkSize.add(casingSize);
		
		List<String[][]> initLineitemMachines = new ArrayList<String[][]>();
		initLineitemMachines.add(InitDataOffsetMachine1.lineitemOffsetWellMX01List);
		initLineitemMachines.add(InitDataOffsetMachine2.lineitemOffsetWellMX02List);
		initLineitemMachines.add(InitDataOffsetMachine3.lineitemOffsetWellMX03List);
		initLineitemMachines.add(InitDataOffsetMachine4.lineitemOffsetWellMX04List);
		initLineitemMachines.add(InitDataOffsetMachine5.lineitemOffsetWellMX05List);

		for (int i = 0; i < machineNameList.size(); i++) {
			String machineName = machineNameList.get(i);
			String[][] initlineitemList = initLineitemMachines.get(i);
			
			Integer index = 1;
			Engine engine = engineService.findByMachineNameAndName(machineName, "Train");
			if (engine != null) {
				engine.setIsTracking(true);
				engineService.save(engine);
				List<LineItem> listLineItem = lineItemService.findByEngineIdOrderByNoAsc(engine.getId());
				List<Section> sectionList = sectionService.findByEngineId(engine.getId());

				if (listLineItem.size() == 0) {
					for (String[] lineItem : initlineitemList) {
						// Put Section
						String sectionName = lineItem[0];
						Section currentSection = null;
						Optional<Section> sectionExist = sectionList.stream().filter(d -> d.getName().equalsIgnoreCase(sectionName))
								.findFirst();
						if (sectionExist.isPresent()) {
							currentSection = sectionExist.get();
						} else {
							currentSection = new Section(engine, sectionName, null, null, null, null, null);
							sectionService.setSectionProperties(currentSection, sectionName);
							sectionList.add(currentSection);
							sectionService.save(currentSection);
						}
						
						Double cost = 0.0;
						boolean checked = true;
						Double length = (lineItem[7] != "" ? Double.valueOf(lineItem[7]) : null);
						Double speed = (lineItem[8] != "" ? Double.valueOf(lineItem[8]) : null);
						LineItem newLineItem = new LineItem(engine, index, currentSection, lineItem[2], lineItem[3], lineItem[4],
								Double.valueOf(lineItem[5]), Double.valueOf(lineItem[6]), cost, length, speed, checked, lineItem[10]);

						lineItemService.save(newLineItem);
						index++;
					}
				}
				machineService.updateTotalDurationDepth(engine.getMachine().getId());
			}
		}
	}

	@Override
	public void initMachineSectionSummary5OffsetMachine() {
		Machine machine = machineService.findByName("MX-01");
		machineService.updateMachineSectionSummary(machine.getId());

		machine = machineService.findByName("MX-02");
		machineService.updateMachineSectionSummary(machine.getId());

		machine = machineService.findByName("MX-03");
		machineService.updateMachineSectionSummary(machine.getId());

		machine = machineService.findByName("MX-04");
		machineService.updateMachineSectionSummary(machine.getId());

		machine = machineService.findByName("MX-05");
		machineService.updateMachineSectionSummary(machine.getId());
	}

	@Override
	public void initGlobalOffsetMachines() {
		// Initialize GlobalOffsetMachines
		if (com.example.model.Enum.GlobalOffsetMachines.isEmpty()) {
			for (String machineName : Enum.GlobalOffsetMachineNames) {
				Machine machine = machineService.findByName(machineName);
				if (machine != null) {
					Enum.GlobalOffsetMachines.add(machine);
				}
			}
		}
	}

	@Override
	public void initGlobalOffsetLineItems() {
		// Initialize GlobalOffsetLineItems
		if (Enum.GlobalOffsetLineItems.isEmpty()) {
			for (String machineName : Enum.GlobalOffsetMachineNames) {
				Engine engine = engineService.findByMachineNameAndName(machineName, "Train");
				List<LineItem> lineItemList = new ArrayList<LineItem>();
				List<LineItem> lineItemPList = new ArrayList<LineItem>();
				if (engine != null) {
					lineItemList = lineItemService.findByEngineIdOrderByNoAsc(engine.getId());
					lineItemPList = lineItemList.stream().filter(d -> d.getActivityType().equals("P")).collect(Collectors.toList());
					
					Enum.GlobalOffsetLineItems.put(engine.getMachine().getId(), lineItemList);
					Enum.GlobalOffsetPLineItems.put(engine.getMachine().getId(), lineItemPList);
				}
			}
		}
	}
	
	@Override
	public void reloadDataOffsetMachine(String machineName) {
		if(!Enum.GlobalOffsetMachineNames.contains(machineName))
			return;
		
		Machine machine = machineService.findByName(machineName);
		if (machine != null) {
			Enum.GlobalOffsetMachines.remove(machine);
			Enum.GlobalOffsetMachines.add(machine);
			System.out.println("Done reloadDataOffsetMachine for machine" + machine.getName());
		}
	}
	
	@Override
	public void reloadDataOffsetLineItems(String machineName) {
		if(!Enum.GlobalOffsetMachineNames.contains(machineName))
			return;
		
		Engine engine = engineService.findByMachineNameAndName(machineName, "Train");
		List<LineItem> lineItemList = new ArrayList<LineItem>();
		List<LineItem> lineItemPList = new ArrayList<LineItem>();
		if (engine != null) {
			lineItemList = lineItemService.findByEngineIdOrderByNoAsc(engine.getId());
			lineItemPList = lineItemList.stream().filter(d -> d.getActivityType().equals("P")).collect(Collectors.toList());
			
			Enum.GlobalOffsetLineItems.put(engine.getMachine().getId(), lineItemList);
			Enum.GlobalOffsetPLineItems.put(engine.getMachine().getId(), lineItemPList);
			
			System.out.println("Done reloadDataOffsetLineItems for machine" + engine.getMachine().getName());
		}
	}
}
