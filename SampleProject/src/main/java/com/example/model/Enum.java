package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enum {

	public static final List<String> GlobalLibHoleSizes = new ArrayList<String>(
			Arrays.asList("3.625", "3.75", "3.875", "4.125", "4.25", "4.5", "4.625", "4.75", "4.758", "4.875", "5.125", "5.375", "5.625",
					"5.75", "5.875", "6", "6.125", "6.25", "6.375", "6.625", "6.75", "6.785", "7.375", "7.625", "7.75", "7.875", "8.375",
					"8.5", "8.625", "8.75", "9", "9.5", "9.625", "9.875", "10.625", "12", "12.25", "13.25", "14.75", "15", "17.5", "22"));

	public static final List<String> GlobalLibCasingSizes = new ArrayList<String>(Arrays.asList("4.5", "5", "5.5", "6.625", "7", "7.625",
			"7.75", "8.625", "9.625", "10.75", "11.75", "13.375", "14", "16", "18.625", "20", "21", "22", "24"));

	public static final List<String> GlobalOffsetMachineNames = new ArrayList<String>(
			Arrays.asList("HBB-03", "TSEA-2C", "TEB-4", "TEB-7", "TEB-9"));

	public static final List<String> GlobalSectionGroups = new ArrayList<String>(Arrays.asList("MIRU", "Drilling", "Completion", "Other"));

	public static final List<Machine> GlobalOffsetMachines = new ArrayList<Machine>();

	public static final Map<String, List<LineItem>> GlobalOffsetLineItems = new HashMap<>();

	public static final Map<String, List<LineItem>> GlobalOffsetPLineItems = new HashMap<>();

	public enum CasingType {
		CASING("Casing"), LINER("Liner"), SLOTTED_LINER("Slotted Liner"), TIEBACK_LINER("Tieback Liner"), OPEN_HOLE("Open Hole");
		private String value;

		private CasingType(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}
	}

	public enum RigType {
		JACKUP_RIG("Jackup Rig"), SUBMERSIBLE_RIG("Submersible Rig"), PLATFORM_RIG("Platform Rig"), SEMI_SUBMERSIBLE_RIG(
				"Semi-submersible Rig"), DRILLSHIP_RIG("Drillship Rig");
		private String value;

		private RigType(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}
	}

	private String enumString;
	private String enumType;

	public Enum(String enumString, String enumType) {
		super();
		this.enumString = enumString;
		this.enumType = enumType;
	}

	public Enum() {
		super();
	}

	public String getEnumString() {
		return enumString;
	}

	public void setEnumString(String enumString) {
		this.enumString = enumString;
	}

	public String getEnumType() {
		return enumType;
	}

	public void setEnumType(String enumType) {
		this.enumType = enumType;
	}

	@Override
	public String toString() {
		return "Enum [enumString=" + enumString + ", enumType=" + enumType + "]";
	}

}
