package com.example.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Unit {
	@GraphId
	Long graphId;

	String id;

	private String code;

	private String name;

	private Double value;

	public Unit() {
		super();
	}

	public Unit(String code, String name, Double value) {
		super();
		this.code = code;
		this.name = name;
		this.value = value;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Unit [graphId=" + graphId + ", id=" + id + ", code=" + code + ", name=" + name + ", value=" + value
				+ "]";
	}
}