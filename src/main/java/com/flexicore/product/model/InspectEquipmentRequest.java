package com.flexicore.product.model;

import com.flexicore.interfaces.dynamic.InvokerParameterInfo;
import com.flexicore.model.dynamic.ExecutionParametersHolder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class InspectEquipmentRequest extends ExecutionParametersHolder {


    @OneToOne(targetEntity = EquipmentFiltering.class)
    @InvokerParameterInfo(displayName = "equipmentFiltering",description = "filtering that defines equipments to inspect")
    private EquipmentFiltering equipmentFiltering;

    @OneToOne(targetEntity = EquipmentFiltering.class)
    public EquipmentFiltering getEquipmentFiltering() {
        return equipmentFiltering;
    }

    public InspectEquipmentRequest setEquipmentFiltering(EquipmentFiltering equipmentFiltering) {
        this.equipmentFiltering = equipmentFiltering;
        return this;
    }
}
