package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.model.BaseclassIdFiltering;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class EquipmentFiltering extends FilteringInformationHolder {


    @OneToMany(targetEntity = BaseclassIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "equipmentFiltering",description = "equipments in equipment groups",refType = EquipmentGroup.class)

    private Set<BaseclassIdFiltering> groupIds = new HashSet<>();
    @OneToMany(targetEntity = BaseclassIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @ListFieldInfo(displayName = "typesToReturnIds",description = "list of canonical class names to return")

    private Set<BaseclassIdFiltering> typesToReturnIds = new HashSet<>();

    @Transient
    @JsonIgnore
    private List<Class<?>> typesToReturn=new ArrayList<>();

    @JsonIgnore
    @Transient
    private List<EquipmentGroup> equipmentGroups = new ArrayList<>();

    @OneToOne(targetEntity = LocationArea.class)
    @FieldInfo(displayName = "locationArea",description = "area to search equipment in")
    private LocationArea locationArea;
    @OneToOne(targetEntity = BaseclassIdFiltering.class)
    @IdRefFieldInfo(displayName = "productTypeId",description = "product type id",refType = ProductType.class,list = false)
    private BaseclassIdFiltering productTypeId;
    @JsonIgnore
    @Transient
    private ProductType productType;
    @OneToMany(targetEntity = BaseclassIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "productStatusIds",description = "equipment with status",refType = ProductStatus.class)
    private Set<BaseclassIdFiltering> productStatusIds = new HashSet<>();

    @OneToMany(targetEntity = BaseclassIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "gateway ids",description = "gateway ids",refType = Gateway.class)
    private Set<BaseclassIdFiltering> gatewayIds = new HashSet<>();
    @JsonIgnore
    @Transient
    private List<ProductStatus> productStatusList = new ArrayList<>();


    @OneToMany(targetEntity = BaseclassIdFiltering.class, mappedBy = "filteringInformationHolder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @IdRefFieldInfo(displayName = "equipmentIds",description = "specific equipments",refType = Equipment.class)

    private Set<BaseclassIdFiltering> equipmentIds = new HashSet<>();

    @JsonIgnore
    @Transient
    private List<Gateway> gateways=new ArrayList<>();

    @OneToMany(targetEntity = BaseclassIdFiltering.class, mappedBy = "filteringInformationHolder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Set<BaseclassIdFiltering> getEquipmentIds() {
        return equipmentIds;
    }

    public EquipmentFiltering setEquipmentIds(Set<BaseclassIdFiltering> equipmentIds) {
        this.equipmentIds = equipmentIds;
        return this;
    }


    @OneToMany(targetEntity = BaseclassIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
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

    @OneToOne(targetEntity = BaseclassIdFiltering.class)
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

    @OneToMany(targetEntity = BaseclassIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
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

    @OneToMany(targetEntity = BaseclassIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<BaseclassIdFiltering> getGatewayIds() {
        return gatewayIds;
    }

    public EquipmentFiltering setGatewayIds(Set<BaseclassIdFiltering> gatewayIds) {
        this.gatewayIds = gatewayIds;
        return this;
    }

    @JsonIgnore
    @Transient
    public List<Gateway> getGateways() {
        return gateways;
    }

    public EquipmentFiltering setGateways(List<Gateway> gateways) {
        this.gateways = gateways;
        return this;
    }

    @OneToMany(targetEntity = BaseclassIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<BaseclassIdFiltering> getTypesToReturnIds() {
        return typesToReturnIds;
    }

    public EquipmentFiltering setTypesToReturnIds(Set<BaseclassIdFiltering> typesToReturnIds) {
        this.typesToReturnIds = typesToReturnIds;
        return this;
    }

    @Transient
    @JsonIgnore
    public List<Class<?>> getTypesToReturn() {
        return typesToReturn;
    }

    public EquipmentFiltering setTypesToReturn(List<Class<?>> typesToReturn) {
        this.typesToReturn = typesToReturn;
        return this;
    }
}
