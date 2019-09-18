package com.flexicore.product.model;

import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.dynamic.ExecutionParametersHolder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class EquipmentStatusRequest extends ExecutionParametersHolder {

    @FieldInfo(
            mandatory = true
    )
    @ManyToOne(
            targetEntity = EquipmentFiltering.class
    )
    private EquipmentFiltering equipmentFiltering;

    @ManyToOne(
            targetEntity = EquipmentFiltering.class
    )
    public EquipmentFiltering getEquipmentFiltering() {
        return equipmentFiltering;
    }

    public <T extends EquipmentStatusRequest> T setEquipmentFiltering(EquipmentFiltering equipmentFiltering) {
        this.equipmentFiltering = equipmentFiltering;
        return (T) this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        if(equipmentFiltering!=null){
            equipmentFiltering.prepareForSave();
        }
    }
}
