package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
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

    @OneToMany(targetEntity = GroupIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "groupIds",description = "equipment group ids",refType = EquipmentGroup.class)
    private Set<GroupIdFiltering> groupIds = new HashSet<>();
    @JsonIgnore
    @Transient
    private List<EquipmentGroup> equipmentGroups = new ArrayList<>();

    @OneToMany(targetEntity = GroupIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "equipmentIds",description = "equipment ids",refType = Equipment.class)
    private List<EquipmentIdFiltering> equipmentIdFilterings=new ArrayList<>();

    @JsonIgnore
    @Transient
    private List<? extends Equipment> equipment=new ArrayList<>();

    @OneToMany(targetEntity = GroupIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<GroupIdFiltering> getGroupIds() {
        return groupIds;
    }

    public GroupFiltering setGroupIds(Set<GroupIdFiltering> groupIds) {
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

    @OneToMany(targetEntity = GroupIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "equipmentIds",description = "equipment ids",refType = Equipment.class)
    public List<EquipmentIdFiltering> getEquipmentIdFilterings() {
        return equipmentIdFilterings;
    }

    public GroupFiltering setEquipmentIdFilterings(List<EquipmentIdFiltering> equipmentIdFilterings) {
        this.equipmentIdFilterings = equipmentIdFilterings;
        return this;
    }

    @JsonIgnore
    @Transient
    public List<? extends  Equipment> getEquipment() {
        return equipment;
    }

    public GroupFiltering setEquipment(List<? extends  Equipment> equipment) {
        this.equipment = equipment;
        return this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        for (GroupIdFiltering groupId : groupIds) {
            groupId.prepareForSave(this);
        }
        for (EquipmentIdFiltering equipmentIdFiltering : equipmentIdFilterings) {
            equipmentIdFiltering.prepareForSave(this);
        }
    }
}
