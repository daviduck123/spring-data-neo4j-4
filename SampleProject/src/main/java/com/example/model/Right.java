package com.example.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Right {

	@GraphId
	Long graphId;

	String id;

	String name;

	public Right() {
		// TODO Auto-generated constructor stub
	}

	public Right(String name) {
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
		return "Right [graphId=" + graphId + ", id=" + id + ", name=" + name + "]";
	}

}
