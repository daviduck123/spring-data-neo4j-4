package com.example.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class ParentClass {
	@GraphId
	Long graphId;

	String id;

	String name;

	public ParentClass() {
		// TODO Auto-generated constructor stub
	}

	public ParentClass(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
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

	@Override
	public String toString() {
		return "ParentClass [graphId=" + graphId + ", id=" + id + ", name=" + name + "]";
	}

}
