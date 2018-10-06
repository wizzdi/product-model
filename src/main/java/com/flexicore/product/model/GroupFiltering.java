package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.BaseclassIdFiltering;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class GroupFiltering extends FilteringInformationHolder {

    @OneToMany(targetEntity = BaseclassIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "groupIds",description = "equipment group ids",refType = EquipmentGroup.class)
    private Set<BaseclassIdFiltering> groupIds = new HashSet<>();
    @JsonIgnore
    @Transient
    private List<EquipmentGroup> equipmentGroups = new ArrayList<>();

    @OneToMany(targetEntity = BaseclassIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<BaseclassIdFiltering> getGroupIds() {
        return groupIds;
    }

    public GroupFiltering setGroupIds(Set<BaseclassIdFiltering> groupIds) {
        this.groupIds = groupIds;
        return this;
    }

    @JsonIgnore
    @Transient
    public List<EquipmentGroup> getEquipmentGroups() {
        return equipmentGroups;
    }

    public GroupFiltering setEquipmentGroups(List<EquipmentGroup> equipmentGroups) {
        this.equipmentGroups = equipmentGroups;
        return this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        for (BaseclassIdFiltering groupId : groupIds) {
            groupId.prepareForSave(this);
        }
    }
}
