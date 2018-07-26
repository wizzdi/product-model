package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class EquipmentGroup extends Product {
    static EquipmentGroup s_Singleton = new EquipmentGroup();
    public static EquipmentGroup s() {
        return s_Singleton;
    }

    @ManyToOne(targetEntity = EquipmentGroup.class)
    private EquipmentGroup parent;

    @OneToMany(targetEntity = EquipmentGroup.class,mappedBy = "parent",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private List<EquipmentGroup> children=new ArrayList<>();


    @OneToMany(targetEntity = EquipmentToGroup.class,mappedBy = "rightside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private List<EquipmentToGroup> equipmentToGroupList=new ArrayList<>();


    @OneToMany(targetEntity = EquipmentToGroup.class,mappedBy = "rightside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    public List<EquipmentToGroup> getEquipmentToGroupList() {
        return equipmentToGroupList;
    }

    public EquipmentGroup setEquipmentToGroupList(List<EquipmentToGroup> equipmentToGroupList) {
        this.equipmentToGroupList = equipmentToGroupList;
        return this;
    }

    @ManyToOne(targetEntity = EquipmentGroup.class)
    public EquipmentGroup getParent() {
        return parent;
    }

    public EquipmentGroup setParent(EquipmentGroup parent) {
        this.parent = parent;
        return this;
    }

    @OneToMany(targetEntity = EquipmentGroup.class,mappedBy = "parent",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    public List<EquipmentGroup> getChildren() {
        return children;
    }

    public EquipmentGroup setChildren(List<EquipmentGroup> children) {
        this.children = children;
        return this;
    }
}
