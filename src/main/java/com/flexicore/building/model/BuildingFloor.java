package com.flexicore.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;
import com.flexicore.product.model.Equipment;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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
}
