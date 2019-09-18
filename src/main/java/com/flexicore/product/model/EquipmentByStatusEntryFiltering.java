package com.flexicore.product.model;

import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EquipmentByStatusEntryFiltering extends FilteringInformationHolder {


    @OneToMany(targetEntity = EquipmentByStatusEventIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @ListFieldInfo(displayName = "equipmentByStatusEventIdFilterings", description = "list of EquipmentByStatusEventIdFiltering")

    private Set<EquipmentByStatusEventIdFiltering> equipmentByStatusEventIdFilterings = new HashSet<>();


    @OneToMany(targetEntity = EquipmentByStatusEventIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @ListFieldInfo(displayName = "equipmentByStatusEventIdFilterings", description = "list of EquipmentByStatusEventIdFiltering")
    public Set<EquipmentByStatusEventIdFiltering> getEquipmentByStatusEventIdFilterings() {
        return equipmentByStatusEventIdFilterings;
    }

    public <T extends EquipmentByStatusEntryFiltering> T setEquipmentByStatusEventIdFilterings(Set<EquipmentByStatusEventIdFiltering> equipmentByStatusEventIdFilterings) {
        this.equipmentByStatusEventIdFilterings = equipmentByStatusEventIdFilterings;
        return (T) this;
    }
}
