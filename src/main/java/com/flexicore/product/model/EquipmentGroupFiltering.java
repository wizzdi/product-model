package com.flexicore.product.model;

import javax.persistence.Entity;

@Entity
public class EquipmentGroupFiltering extends EquipmentFiltering {

    private int precision;

    public int getPrecision() {
        return precision;
    }

    public EquipmentGroupFiltering setPrecision(int precision) {
        this.precision = precision;
        return this;
    }
}
