package com.example.model;

import java.util.Comparator;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class LineItem {
	@GraphId
	Long graphId;

	String id;

	@Relationship(type = "HAS_ENGINE", direction = "OUTGOING")
	private Engine engine;

	@Relationship(type = "HAS_SECTION", direction = "OUTGOING")
	private Section section;

	private Integer no;

	private String name;

	private String activityCode;

	private String activityType;

	private String nptSummary;

	private String programName;

	private String milestone;

	private Double duration;

	private Double durationILT;

	private Double durationInefficiency;

	private Double plannedMD;

	private Double length;

	private Double speed;

	private Double speedILT;

	private Double Cost;

	private Boolean checked;

	public Long getGraphId() {
		return graphId;
	}

	public void setGraphId(Long graphId) {
		this.graphId = graphId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getNptSummary() {
		return nptSummary;
	}

	public void setNptSummary(String nptSummary) {
		this.nptSummary = nptSummary;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getMilestone() {
		return milestone;
	}

	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Double getDurationILT() {
		return durationILT;
	}

	public void setDurationILT(Double durationILT) {
		this.durationILT = durationILT;
	}

	public Double getDurationInefficiency() {
		return durationInefficiency;
	}

	public void setDurationInefficiency(Double durationInefficiency) {
		this.durationInefficiency = durationInefficiency;
	}

	public Double getPlannedMD() {
		return plannedMD;
	}

	public void setPlannedMD(Double plannedMD) {
		this.plannedMD = plannedMD;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getSpeedILT() {
		return speedILT;
	}

	public void setSpeedILT(Double speedILT) {
		this.speedILT = speedILT;
	}

	public Double getCost() {
		return Cost;
	}

	public void setCost(Double cost) {
		Cost = cost;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public LineItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LineItem(Engine engine, Integer no, Section section, String name, String activityCode, String activityType, Double duration,
			Double plannedMD, Double cost, Double length, Double speed, boolean checked, String programName){
		super();
		this.engine = engine;
		this.section = section;
		this.no = no;
		this.name = name;
		this.activityCode = activityCode;
		this.activityType = activityType;
		this.programName = programName;
		this.duration = duration;
		this.plannedMD = plannedMD;
		this.length = length;
		this.speed = speed;
		Cost = cost;
		this.checked = checked;
	}

	public LineItem(Long graphId, String id, Engine engine, Section section, Integer no, String name,
			String activityCode, String activityType, String nptSummary, String programName, String milestone,
			Double duration, Double durationILT, Double durationInefficiency, Double plannedMD, Double length,
			Double speed, Double speedILT, Double cost, Boolean checked) {
		super();
		this.graphId = graphId;
		this.id = id;
		this.engine = engine;
		this.section = section;
		this.no = no;
		this.name = name;
		this.activityCode = activityCode;
		this.activityType = activityType;
		this.nptSummary = nptSummary;
		this.programName = programName;
		this.milestone = milestone;
		this.duration = duration;
		this.durationILT = durationILT;
		this.durationInefficiency = durationInefficiency;
		this.plannedMD = plannedMD;
		this.length = length;
		this.speed = speed;
		this.speedILT = speedILT;
		Cost = cost;
		this.checked = checked;
	}

	public static class Comparators {

		public static final Comparator<LineItem> NO = new Comparator<LineItem>() {
			@Override
			public int compare(LineItem o1, LineItem o2) {
				return o1.getNo().compareTo(o2.getNo());
			}
		};

		private Comparators() {
			// Constructor
		}
	}
}