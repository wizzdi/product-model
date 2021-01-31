package com.flexicore.building.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.converters.JsonConverter;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;
import com.flexicore.product.model.Equipment;
import com.flexicore.security.SecurityContext;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class BuildingFloor extends Baseclass {

	public BuildingFloor() {
	}

	public BuildingFloor(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	private int floorNumber;
	@ManyToOne(targetEntity = Building.class)
	private Building building;

	@ManyToOne(targetEntity = FileResource.class)
	private FileResource diagram;

	@ManyToOne(targetEntity = FileResource.class)
	private FileResource diagram3D;

	@JsonIgnore
	@OneToMany(targetEntity = Equipment.class,mappedBy = "buildingFloor")
	private List<Equipment> equipments=new ArrayList<>();
	@Column(columnDefinition = "jsonb")
	@Convert(converter = JsonConverter.class)
	private Map<String, Object> jsonNode;


	public int getFloorNumber() {
		return floorNumber;
	}

	public BuildingFloor setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
		return this;
	}

	@ManyToOne(targetEntity = FileResource.class)
	public FileResource getDiagram() {
		return diagram;
	}

	public BuildingFloor setDiagram(FileResource diagram) {
		this.diagram = diagram;
		return this;
	}

	@ManyToOne(targetEntity = Building.class)
	public Building getBuilding() {
		return building;
	}

	public BuildingFloor setBuilding(Building building) {
		this.building = building;
		return this;
	}

	@ManyToOne(targetEntity = FileResource.class)
	public FileResource getDiagram3D() {
		return diagram3D;
	}

	public <T extends BuildingFloor> T setDiagram3D(FileResource diagram3D) {
		this.diagram3D = diagram3D;
		return (T) this;
	}

	@JsonIgnore
	@OneToMany(targetEntity = Equipment.class,mappedBy = "buildingFloor")
	public List<Equipment> getEquipments() {
		return equipments;
	}

	public <T extends BuildingFloor> T setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
		return (T) this;
	}
	@JsonIgnore
	@Transient
	public Map<String, Object> getJsonNode() {
		return jsonNode;
	}

	@JsonAnyGetter
	public Map<String, Object> any() {
		return jsonNode;
	}

	public <T extends Baseclass> T setJsonNode(Map<String, Object> jsonNode) {
		this.jsonNode = jsonNode;
		return (T) this;
	}
}
