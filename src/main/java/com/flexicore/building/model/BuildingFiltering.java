package com.flexicore.building.model;

import com.flexicore.product.model.EquipmentFiltering;

import javax.persistence.Entity;

@Entity
public class BuildingFiltering extends EquipmentFiltering {

	@Override
	public void prepareForSave() {
		super.prepareForSave();

	}
}
