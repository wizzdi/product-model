package com.flexicore.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.product.model.EquipmentExternalIdFiltering;

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
	private Set<BuildingFloorIdFiltering> buildingFloorIdFilterings = new HashSet<>();

	@OneToMany(targetEntity = EquipmentExternalIdFiltering.class, mappedBy = "filteringInformationHolder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@ListFieldInfo(displayName = "externalIds",description = "filter by external ids",listType = EquipmentExternalIdFiltering.class)
	private Set<EquipmentExternalIdFiltering> externalIds = new HashSet<>();


	@JsonIgnore
	@Transient
	private List<BuildingFloor> buildingFloors;

	@OneToMany(targetEntity = BuildingFloorIdFiltering.class, cascade = {
			CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
	public Set<BuildingFloorIdFiltering> getBuildingFloorIdFilterings() {
		return buildingFloorIdFilterings;
	}



	public <T extends RoomFiltering> T setBuildingFloorIdFilterings(Set<BuildingFloorIdFiltering> buildingFloorIdFilterings) {
		this.buildingFloorIdFilterings = buildingFloorIdFilterings;
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

	@OneToMany(targetEntity = EquipmentExternalIdFiltering.class, mappedBy = "filteringInformationHolder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public Set<EquipmentExternalIdFiltering> getExternalIds() {
		return externalIds;
	}

	public <T extends RoomFiltering> T setExternalIds(Set<EquipmentExternalIdFiltering> externalEquipmentIds) {
		this.externalIds = externalEquipmentIds;
		return (T) this;
	}

	@Override
	public void prepareForSave() {
		super.prepareForSave();
		for (BuildingFloorIdFiltering buildingIdFiltering : buildingFloorIdFilterings) {
			buildingIdFiltering.prepareForSave(this);
		}
		for (EquipmentExternalIdFiltering externalEquipmentId : externalIds) {
			externalEquipmentId.prepareForSave(this);
		}

	}
}
