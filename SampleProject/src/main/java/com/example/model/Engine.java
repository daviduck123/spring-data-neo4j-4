package com.example.model;

import java.util.Date;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Engine {
	@GraphId
	Long graphId;

	String id;

	@Relationship(type = "HAS_MACHINE", direction = "OUTGOING")
	private Machine machine;

	private String name;

	private Boolean active;

	private Boolean isTracking;
	
	private Boolean lineEngineInactive;

	private Boolean isTemporary;

	private Date lastModified;

	public Engine() {
		super();
	}

	public Engine(Machine machine, String name) {
		super();
		this.machine = machine;
		this.name = name;
		this.active = false;
		this.isTracking = false;
		this.lineEngineInactive = false;
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

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getIsTracking() {
		return isTracking;
	}

	public void setIsTracking(Boolean isTracking) {
		this.isTracking = isTracking;
	}

	public Boolean getLineEngineInactive() {
		return lineEngineInactive;
	}

	public void setLineEngineInactive(Boolean lineEngineInactive) {
		this.lineEngineInactive = lineEngineInactive;
	}

	public Boolean getIsTemporary() {
		return isTemporary;
	}

	public void setIsTemporary(Boolean isTemporary) {
		this.isTemporary = isTemporary;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "Engine [graphId=" + graphId + ", id=" + id + ", machine=" + machine + ", name=" + name + ", active="
				+ active + ", isTracking=" + isTracking + ", lineEngineInactive=" + lineEngineInactive
				+ ", isTemporary=" + isTemporary + ", lastModified=" + lastModified + "]";
	}
}
