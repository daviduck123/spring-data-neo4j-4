package com.example.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class MachineSectionSummary {
	@GraphId
	Long graphId;
	String id;
	@Relationship(type = "HAS_MACHINE", direction = "OUTGOING")
	private Machine machine;
	private String sectionGroup;
	private String category;
	private Double duration;
	private Double percentDuration;
	private Double cost;
	private Double percentCost;
	@Relationship(type = "HAS_CURRENCY", direction = "OUTGOING")
	private Currency currency;

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

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public String getSectionGroup() {
		return sectionGroup;
	}

	public void setSectionGroup(String sectionGroup) {
		this.sectionGroup = sectionGroup;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Double getPercentDuration() {
		return percentDuration;
	}

	public void setPercentDuration(Double percentDuration) {
		this.percentDuration = percentDuration;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getPercentCost() {
		return percentCost;
	}

	public void setPercentCost(Double percentCost) {
		this.percentCost = percentCost;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public MachineSectionSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MachineSectionSummary(Machine machine, String sectionGroup, String category, Double duration,
			Double percentDuration, Double cost, Double percentCost, Currency currency) {
		super();
		this.machine = machine;
		this.sectionGroup = sectionGroup;
		this.category = category;
		this.duration = duration;
		this.percentDuration = percentDuration;
		this.cost = cost;
		this.percentCost = percentCost;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "MachineSectionSummary [graphId=" + graphId + ", id=" + id + ", machine=" + machine + ", sectionGroup="
				+ sectionGroup + ", category=" + category + ", duration=" + duration + ", percentDuration="
				+ percentDuration + ", cost=" + cost + ", percentCost=" + percentCost + ", currency=" + currency + "]";
	}

}