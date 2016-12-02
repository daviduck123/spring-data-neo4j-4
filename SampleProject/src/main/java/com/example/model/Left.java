package com.example.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Left {

	@GraphId
	Long graphId;

	String id;

	String name;

	ParentClass parent;

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

	public ParentClass getParent() {
		return parent;
	}

	public void setParent(ParentClass parent) {
		this.parent = parent;
	}

	public Left() {
		// TODO Auto-generated constructor stub
	}
	public Left(String name, ParentClass parent) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Left [graphId=" + graphId + ", id=" + id + ", name=" + name + ", parent=" + parent + "]";
	}
}
