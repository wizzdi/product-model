package com.flexicore.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BuildingIdFiltering {

	@Id
	private String filterId;

	@FieldInfo(displayName = "string", description = "string filter", mandatory = true)
	private String id;
	@ManyToOne(targetEntity = FilteringInformationHolder.class)
	@JsonIgnore
	private FilteringInformationHolder filteringInformationHolder;

	public BuildingIdFiltering() {
	}

	public String getId() {
		return id;
	}

	public BuildingIdFiltering setId(String id) {
		this.id = id;
		return this;
	}

	public BuildingIdFiltering(String id) {
		this.id = id;
	}

	@Id
	public String getFilterId() {
		return filterId;
	}

	public BuildingIdFiltering setFilterId(String filterId) {
		this.filterId = filterId;
		return this;
	}

	@ManyToOne(targetEntity = FilteringInformationHolder.class)
	@JsonIgnore
	public FilteringInformationHolder getFilteringInformationHolder() {
		return filteringInformationHolder;
	}

	public BuildingIdFiltering setFilteringInformationHolder(
			FilteringInformationHolder filteringInformationHolder) {
		this.filteringInformationHolder = filteringInformationHolder;
		return this;
	}

	public void prepareForSave(
			FilteringInformationHolder filteringInformationHolder) {
		filterId = Baseclass.getBase64ID();
		this.filteringInformationHolder = filteringInformationHolder;

	}
}
