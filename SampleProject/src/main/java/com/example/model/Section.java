package com.example.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Section {
	@GraphId
	Long graphId;

	String id;

	@Relationship(type = "HAS_ENGINE", direction = "OUTGOING")
	private Engine engine;

	private String name;

	private String group;

	private String holeSize;

	private String casingSize;

	private Double md;

	private Double tvd;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getHoleSize() {
		return holeSize;
	}

	public void setHoleSize(String holeSize) {
		this.holeSize = holeSize;
	}

	public String getCasingSize() {
		return casingSize;
	}

	public void setCasingSize(String casingSize) {
		this.casingSize = casingSize;
	}

	public Double getMd() {
		return md;
	}

	public void setMd(Double md) {
		this.md = md;
	}

	public Double getTvd() {
		return tvd;
	}

	public void setTvd(Double tvd) {
		this.tvd = tvd;
	}

	public Section() {
		super();
	}

	public Section(Engine engine, String name, String group, String holeSize,
			String casingSize, Double md, Double tvd) {
		super();
		this.engine = engine;
		this.name = name;
		this.group = group;
		this.holeSize = holeSize;
		this.casingSize = casingSize;
		this.md = md;
		this.tvd = tvd;
	}

	@Override
	public String toString() {
		return "Section [graphId=" + graphId + ", id=" + id + ", engine=" + engine + ", name=" + name + ", group="
				+ group + ", holeSize=" + holeSize + ", casingSize=" + casingSize + ", md=" + md + ", tvd=" + tvd + "]";
	}
	
}