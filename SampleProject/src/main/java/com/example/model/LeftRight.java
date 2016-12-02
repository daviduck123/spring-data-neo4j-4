package com.example.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class LeftRight {

	@GraphId
	Long graphId;

	String id;

	@Relationship(type = "LEFTRIGHT_LEFT", direction = "OUTGOING")
	Left left;

	@Relationship(type = "LEFTRIGHT_RIGHT", direction = "OUTGOING")
	Right right;

	public LeftRight() {
		// TODO Auto-generated constructor stub
	}

	public LeftRight(Left left, Right right) {
		// TODO Auto-generated constructor stub
		this.left = left;
		this.right = right;
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

	public Left getLeft() {
		return left;
	}

	public void setLeft(Left left) {
		this.left = left;
	}

	public Right getRight() {
		return right;
	}

	public void setRight(Right right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "LeftRight [graphId=" + graphId + ", id=" + id + ", left=" + left + ", right=" + right + "]";
	}

}
