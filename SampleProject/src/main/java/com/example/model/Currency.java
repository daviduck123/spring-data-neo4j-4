package com.example.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Currency {
	@GraphId
	Long graphId;

	String id;

	private String name;

	private Double exchangeRate;

	public Currency() {
		super();
	}

	public Currency(String name, Double exchangeRate) {
		super();
		this.name = name;
		this.exchangeRate = exchangeRate;
	}

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

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Override
	public String toString() {
		return "Currency [graphId=" + graphId + ", id=" + id + ", name=" + name + ", exchangeRate=" + exchangeRate + "]";
	}
}