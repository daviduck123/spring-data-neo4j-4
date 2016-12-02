package com.example.service;

public interface InitializationService {

	void initData();

	void initUnit();

	void initCurrency();

	void initMachine();

	void initMachineSectionSummary();

	void initEngine();

	void initLineItem();

	void initMachineSectionSummary5OffsetMachine();

	void initGlobalOffsetMachines();

	void initGlobalOffsetLineItems();
	
	void reloadDataOffsetMachine(String machineName);
	
	void reloadDataOffsetLineItems(String machineName);
}
