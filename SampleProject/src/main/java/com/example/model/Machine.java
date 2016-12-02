package com.example.model;

import java.util.Date;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Transient;

@NodeEntity
public class Machine {
	@GraphId
	Long graphId;
	String id;
	private String name;
	private String field;
	private Date startDate;
	private Date endDate;
	@Relationship(type = "HAS_DEPTH_UNIT", direction = "OUTGOING")
	private Unit depthUnit;
	private Double duration;
	@Relationship(type = "HAS_DURATION_UNIT", direction = "OUTGOING")
	private Unit durationUnit;
	private Double cost;
	@Relationship(type = "HAS_CURRENCY", direction = "OUTGOING")
	private Currency currency;
	private Double exchangeRate;
	@Transient
	private Boolean maxCost;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Unit getDepthUnit() {
		return depthUnit;
	}

	public void setDepthUnit(Unit depthUnit) {
		this.depthUnit = depthUnit;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Unit getDurationUnit() {
		return durationUnit;
	}

	public void setDurationUnit(Unit durationUnit) {
		this.durationUnit = durationUnit;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Boolean getMaxCost() {
		return maxCost;
	}

	public void setMaxCost(Boolean maxCost) {
		this.maxCost = maxCost;
	}

	public Machine(String id, String name, String field, Date startDate, Date endDate, Unit depthUnit, Double duration,
			Unit durationUnit, Double cost, Currency currency, Double exchangeRate, Boolean maxCost) {
		super();
		this.id = id;
		this.name = name;
		this.field = field;
		this.startDate = startDate;
		this.endDate = endDate;
		this.depthUnit = depthUnit;
		this.duration = duration;
		this.durationUnit = durationUnit;
		this.cost = cost;
		this.currency = currency;
		this.exchangeRate = exchangeRate;
		this.maxCost = maxCost;
	}

	public Machine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Machine(String name, String field, Double depth, Unit depthUnit, Date startDate, Date endDate, Double duration, Double cost) {
		this.name = name;
		this.field = field;
		this.startDate = startDate;
		this.endDate = endDate;
		this.depthUnit = depthUnit;
		this.duration = duration;
		this.cost = cost;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Machine [graphId=" + graphId + ", id=" + id + ", name=" + name + ", field=" + field + ", startDate="
				+ startDate + ", endDate=" + endDate + ", depthUnit=" + depthUnit + ", duration=" + duration
				+ ", durationUnit=" + durationUnit + ", cost=" + cost + ", currency=" + currency + ", exchangeRate="
				+ exchangeRate + ", maxCost=" + maxCost + "]";
	}
}