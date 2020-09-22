package com.flexicore.product.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.product.model.Equipment;
import com.flexicore.product.model.EquipmentLocation;
import com.flexicore.product.model.EquipmentRef;
import com.flexicore.request.BaseclassNoSQLFilter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class EquipmentLocationFiltering extends BaseclassNoSQLFilter {

    @JsonIgnore
    @OneToMany(targetEntity = EquipmentRef.class,mappedBy = "filteringInformationHolder")
    private Set<EquipmentRef> equipmentIds=new HashSet<>();
    @Transient
    @JsonIgnore
    private List<Equipment> equipment;


    @JsonIgnore
    @OneToMany(targetEntity = EquipmentRef.class,mappedBy = "filteringInformationHolder")
    public Set<EquipmentRef> getEquipmentIds() {
        return equipmentIds;
    }

    public <T extends EquipmentLocationFiltering> T setEquipmentIds(Set<EquipmentRef> equipmentIds) {
        this.equipmentIds = equipmentIds;
        return (T) this;
    }

    @Transient
    @JsonIgnore
    public List<Equipment> getEquipment() {
        return equipment;
    }

    public <T extends EquipmentLocationFiltering> T setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
        return (T) this;
    }

    @Override
    public String getBaseclassNoSQLType() {
        return EquipmentLocation.class.getCanonicalName();
    }
}
