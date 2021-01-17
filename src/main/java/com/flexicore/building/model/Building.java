package com.flexicore.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.product.model.Equipment;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Building extends Equipment {

	public Building() {
	}

	public Building(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@OneToMany(targetEntity = BuildingFloor.class, mappedBy = "building")
	@JsonIgnore
	private List<BuildingFloor> floors = new ArrayList<>();
	@ManyToOne(targetEntity = Campus.class)
	private Campus campus;

	@OneToMany(targetEntity = BuildingFloor.class, mappedBy = "building")
	@JsonIgnore
	public List<BuildingFloor> getFloors() {
		return floors;
	}

	public Building setFloors(List<BuildingFloor> floors) {
		this.floors = floors;
		return this;
	}

	@ManyToOne(targetEntity = Campus.class)
	public Campus getCampus() {
		return campus;
	}

	public <T extends Building> T setCampus(Campus campus) {
		this.campus = campus;
		return (T) this;
	}
}
