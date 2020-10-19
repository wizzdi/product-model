package com.flexicore.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.product.model.Equipment;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room extends Baseclass {

	private String externalId;
	private double centerX;
	private double centerY;
	@JsonIgnore
	@OneToMany(targetEntity = Equipment.class,mappedBy = "room")
	private List<Equipment> equipments=new ArrayList<>();

	public Room() {
	}

	public Room(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}


	@ManyToOne(targetEntity = BuildingFloor.class)
	private BuildingFloor buildingFloor;

	@ManyToOne(targetEntity = BuildingFloor.class)
	public BuildingFloor getBuildingFloor() {
		return buildingFloor;
	}

	public <T extends Room> T setBuildingFloor(BuildingFloor buildingFloor) {
		this.buildingFloor = buildingFloor;
		return (T) this;
	}

	public String getExternalId() {
		return externalId;
	}

	public <T extends Room> T setExternalId(String externalId) {
		this.externalId = externalId;
		return (T) this;
	}

	@JsonIgnore
	@OneToMany(targetEntity = Equipment.class,mappedBy = "room")
	public List<Equipment> getEquipments() {
		return equipments;
	}

	public <T extends Room> T setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
		return (T) this;
	}

	public double getCenterX() {
		return centerX;
	}

	public <T extends Room> T setCenterX(double centerX) {
		this.centerX = centerX;
		return (T) this;
	}

	public double getCenterY() {
		return centerY;
	}

	public <T extends Room> T setCenterY(double centerY) {
		this.centerY = centerY;
		return (T) this;
	}
}
