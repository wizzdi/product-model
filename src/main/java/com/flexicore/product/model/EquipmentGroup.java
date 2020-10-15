package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.PermissionGroup;
import com.flexicore.security.SecurityContext;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class EquipmentGroup extends Baseclass {

    private String externalId;


    public EquipmentGroup() {
    }

    public EquipmentGroup(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @OneToOne(targetEntity = PermissionGroup.class)
    private PermissionGroup relatedPermissionGroup;

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

    @OneToOne(targetEntity = PermissionGroup.class)
    public PermissionGroup getRelatedPermissionGroup() {
        return relatedPermissionGroup;
    }

    public <T extends EquipmentGroup> T setRelatedPermissionGroup(PermissionGroup relatedPermissionGroup) {
        this.relatedPermissionGroup = relatedPermissionGroup;
        return (T) this;
    }

    public String getExternalId() {
        return externalId;
    }

    public <T extends EquipmentGroup> T setExternalId(String externalId) {
        this.externalId = externalId;
        return (T) this;
    }
}
