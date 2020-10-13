package com.flexicore.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class RoomFiltering extends FilteringInformationHolder {

	@OneToMany(targetEntity = BuildingFloorIdFiltering.class, cascade = {
			CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "building floor", description = "floors in building", refType = BuildingFloor.class)
	private Set<BuildingFloorIdFiltering> buildingIdFilterings = new HashSet<>();

	@JsonIgnore
	@Transient
	private List<BuildingFloor> buildingFloors;

	@OneToMany(targetEntity = BuildingFloorIdFiltering.class, cascade = {
			CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
	public Set<BuildingFloorIdFiltering> getBuildingIdFilterings() {
		return buildingIdFilterings;
	}



	public <T extends RoomFiltering> T setBuildingIdFilterings(Set<BuildingFloorIdFiltering> buildingIdFilterings) {
		this.buildingIdFilterings = buildingIdFilterings;
		return (T) this;
	}

	@JsonIgnore
	@Transient
	public List<BuildingFloor> getBuildingFloors() {
		return buildingFloors;
	}

	public <T extends RoomFiltering> T setBuildingFloors(List<BuildingFloor> buildingFloors) {
		this.buildingFloors = buildingFloors;
		return (T) this;
	}

	@Override
	public void prepareForSave() {
		super.prepareForSave();
		for (BuildingFloorIdFiltering buildingIdFiltering : buildingIdFilterings) {
			buildingIdFiltering.prepareForSave(this);
		}

	}
}
