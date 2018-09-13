package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.BaseclassIdFiltering;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class EquipmentFiltering extends FilteringInformationHolder {


    @OneToMany(targetEntity = BaseclassIdFiltering.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "filteringInformationHolder")
    private Set<BaseclassIdFiltering> groupIds =new HashSet<>();
    @JsonIgnore
    @Transient
    private List<EquipmentGroup> equipmentGroups=new ArrayList<>();

    @OneToOne(targetEntity = LocationArea.class)
    private LocationArea locationArea;
    @OneToOne(targetEntity = BaseclassIdFiltering.class )
    private BaseclassIdFiltering productTypeId;
    @JsonIgnore
    @Transient
    private ProductType productType;
    @OneToMany(targetEntity = BaseclassIdFiltering.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "filteringInformationHolder")
    private Set<BaseclassIdFiltering> productStatusIds=new HashSet<>();
    @JsonIgnore
    @Transient
    private List<ProductStatus> productStatusList=new ArrayList<>();

    private String canonicalClassName;


    @OneToMany(targetEntity = BaseclassIdFiltering.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "filteringInformationHolder")
    public Set<BaseclassIdFiltering> getGroupIds() {
        return groupIds;
    }

    public EquipmentFiltering setGroupIds(Set<BaseclassIdFiltering> groupIds) {
        this.groupIds = groupIds;
        return this;
    }

    @OneToOne(targetEntity = LocationArea.class)

    public LocationArea getLocationArea() {
        return locationArea;
    }

    public EquipmentFiltering setLocationArea(LocationArea locationArea) {
        this.locationArea = locationArea;
        return this;
    }

    @JsonIgnore
    @Transient
    public List<EquipmentGroup> getEquipmentGroups() {
        return equipmentGroups;
    }

    public EquipmentFiltering setEquipmentGroups(List<EquipmentGroup> equipmentGroups) {
        this.equipmentGroups = equipmentGroups;
        return this;
    }

    @OneToOne(targetEntity = BaseclassIdFiltering.class )
    public BaseclassIdFiltering getProductTypeId() {
        return productTypeId;
    }

    public EquipmentFiltering setProductTypeId(BaseclassIdFiltering productTypeId) {
        this.productTypeId = productTypeId;
        return this;
    }

    @JsonIgnore
    @Transient
    public ProductType getProductType() {
        return productType;
    }

    public EquipmentFiltering setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    @OneToMany(targetEntity = BaseclassIdFiltering.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "filteringInformationHolder")
    public Set<BaseclassIdFiltering> getProductStatusIds() {
        return productStatusIds;
    }

    public EquipmentFiltering setProductStatusIds(Set<BaseclassIdFiltering> productStatusIds) {
        this.productStatusIds = productStatusIds;
        return this;
    }

    @JsonIgnore
    @Transient
    public List<ProductStatus> getProductStatusList() {
        return productStatusList;
    }

    public EquipmentFiltering setProductStatusList(List<ProductStatus> productStatusList) {
        this.productStatusList = productStatusList;
        return this;
    }

    public String getCanonicalClassName() {
        return canonicalClassName;
    }

    public EquipmentFiltering setCanonicalClassName(String canonicalClassName) {
        this.canonicalClassName = canonicalClassName;
        return this;
    }



}
