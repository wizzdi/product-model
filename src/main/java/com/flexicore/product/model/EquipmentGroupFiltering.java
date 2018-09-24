package com.flexicore.product.model;

import com.flexicore.interfaces.dynamic.FieldInfo;

import javax.persistence.Entity;

@Entity
public class EquipmentGroupFiltering extends EquipmentFiltering {

    @FieldInfo(displayName = "precision",description = "geo hash percision")
    private int precision;

    public int getPrecision() {
        return precision;
    }

    public EquipmentGroupFiltering setPrecision(int precision) {
        this.precision = precision;
        return this;
    }
}
