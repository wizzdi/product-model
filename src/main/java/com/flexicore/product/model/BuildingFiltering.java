package com.flexicore.product.model;


import javax.persistence.Entity;

@Entity
public class BuildingFiltering extends EquipmentFiltering {

    @Override
    public void prepareForSave() {
        super.prepareForSave();

    }
}
