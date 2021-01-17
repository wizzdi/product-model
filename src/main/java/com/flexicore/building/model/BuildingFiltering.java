package com.flexicore.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.product.model.EquipmentFiltering;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class BuildingFiltering extends EquipmentFiltering {

	@OneToMany(targetEntity = CampusIdFiltering.class, cascade = {
			CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "building", description = "campus ids", refType = Campus.class)
	private Set<CampusIdFiltering> campusIdFilterings = new HashSet<>();

	@JsonIgnore
	@Transient
	private List<Campus> campuses;

	@OneToMany(targetEntity = CampusIdFiltering.class, cascade = {
			CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "building", description = "campus ids", refType = Campus.class)
	public Set<CampusIdFiltering> getCampusIdFilterings() {
		return campusIdFilterings;
	}

	public BuildingFiltering setCampusIdFilterings(
			Set<CampusIdFiltering> buildingIdFilterings) {
		this.campusIdFilterings = buildingIdFilterings;
		return this;
	}

	@Transient
	@JsonIgnore
	public List<Campus> getCampuses() {
		return campuses;
	}

	public BuildingFiltering setCampuses(List<Campus> campuses) {
		this.campuses = campuses;
		return this;
	}

	@Override
	public void prepareForSave() {
		super.prepareForSave();
		if (campusIdFilterings != null) {
			for (CampusIdFiltering campusIdFiltering : campusIdFilterings) {
				campusIdFiltering.prepareForSave(this);
			}
		}

	}
}
