package com.flexicore.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Campus extends Baseclass {

	public Campus() {
	}

	public Campus(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@JsonIgnore
	@OneToMany(targetEntity = Building.class,mappedBy = "campus")
	private List<Building> buildings=new ArrayList<>();


	@JsonIgnore
	@OneToMany(targetEntity = Building.class,mappedBy = "campus")
	public List<Building> getBuildings() {
		return buildings;
	}

	public <T extends Campus> T setBuildings(List<Building> buildings) {
		this.buildings = buildings;
		return (T) this;
	}
}
