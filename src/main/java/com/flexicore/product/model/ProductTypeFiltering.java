package com.flexicore.product.model;


import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ProductTypeFiltering extends FilteringInformationHolder {


    @FieldInfo(description = "will only return product statuses that are used by the product that match this filter")
    @ManyToOne(targetEntity = EquipmentFiltering.class)
    private EquipmentFiltering equipmentFiltering;

    @ManyToOne(targetEntity = EquipmentFiltering.class)
    public EquipmentFiltering getEquipmentFiltering() {
        return equipmentFiltering;
    }

    public <T extends ProductTypeFiltering> T setEquipmentFiltering(EquipmentFiltering equipmentFiltering) {
        this.equipmentFiltering = equipmentFiltering;
        return (T) this;
    }
}
