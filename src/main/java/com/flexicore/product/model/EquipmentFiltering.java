package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.territories.Neighbourhood;
import com.flexicore.model.territories.Street;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class EquipmentFiltering extends FilteringInformationHolder {


    @OneToMany(targetEntity = GroupIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "equipmentFiltering",description = "equipments in equipment groups",refType = EquipmentGroup.class)

    private Set<GroupIdFiltering> groupIds = new HashSet<>();
    @OneToMany(targetEntity = TypeToReturnFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @ListFieldInfo(displayName = "typesToReturnIds",description = "list of canonical class names to return")

    private Set<TypeToReturnFiltering> typesToReturnIds = new HashSet<>();

    @Transient
    @JsonIgnore
    private List<Class<?>> typesToReturn=new ArrayList<>();

    @JsonIgnore
    @Transient
    private List<EquipmentGroup> equipmentGroups = new ArrayList<>();

    @OneToOne(targetEntity = LocationArea.class)
    @FieldInfo(displayName = "locationArea",description = "area to search equipment in")
    private LocationArea locationArea;
    @OneToOne(targetEntity = ProductTypeIdFiltering.class)
    @IdRefFieldInfo(displayName = "productTypeId",description = "product type id",refType = ProductType.class,list = false)
    private ProductTypeIdFiltering productTypeId;
    @OneToMany(targetEntity = NeighbourhoodIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "neighbourhoods",description = "neighbourhood ids",refType = Neighbourhood.class)
    private Set<NeighbourhoodIdFiltering> neighbourhoodIds=new HashSet<>();

    @JsonIgnore
    @Transient
    private List<Neighbourhood> neighbourhoods=new ArrayList<>();

    @OneToMany(targetEntity = StreetIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "streetIds",description = "street ids",refType = Street.class)
    private Set<StreetIdFiltering> streetIds=new HashSet<>();

    @JsonIgnore
    @Transient
    private List<Street> streets=new ArrayList<>();

    @JsonIgnore
    @Transient
    private ProductType productType;
    @OneToMany(targetEntity = ProductStatusIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "productStatusIds",description = "equipment with status",refType = ProductStatus.class)
    private Set<ProductStatusIdFiltering> productStatusIds = new HashSet<>();

    @OneToMany(targetEntity = GatewayIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "gateway ids",description = "gateway ids",refType = Gateway.class)
    private Set<GatewayIdFiltering> gatewayIds = new HashSet<>();
    @JsonIgnore
    @Transient
    private List<ProductStatus> productStatusList = new ArrayList<>();


    @OneToMany(targetEntity = EquipmentIdFiltering.class, mappedBy = "filteringInformationHolder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @IdRefFieldInfo(displayName = "equipmentIds",description = "specific equipments",refType = Equipment.class)

    private Set<EquipmentIdFiltering> equipmentIds = new HashSet<>();

    @JsonIgnore
    @Transient
    private List<Gateway> gateways=new ArrayList<>();

    @OneToMany(targetEntity = EquipmentIdFiltering.class, mappedBy = "filteringInformationHolder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Set<EquipmentIdFiltering> getEquipmentIds() {
        return equipmentIds;
    }

    public EquipmentFiltering setEquipmentIds(Set<EquipmentIdFiltering> equipmentIds) {
        this.equipmentIds = equipmentIds;
        return this;
    }


    @OneToMany(targetEntity = GroupIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<GroupIdFiltering> getGroupIds() {
        return groupIds;
    }

    public EquipmentFiltering setGroupIds(Set<GroupIdFiltering> groupIds) {
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

    @OneToOne(targetEntity = ProductTypeIdFiltering.class)
    public ProductTypeIdFiltering getProductTypeId() {
        return productTypeId;
    }

    public EquipmentFiltering setProductTypeId(ProductTypeIdFiltering productTypeId) {
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

    @OneToMany(targetEntity = ProductStatusIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<ProductStatusIdFiltering> getProductStatusIds() {
        return productStatusIds;
    }

    public EquipmentFiltering setProductStatusIds(Set<ProductStatusIdFiltering> productStatusIds) {
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

    @OneToMany(targetEntity = GatewayIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<GatewayIdFiltering> getGatewayIds() {
        return gatewayIds;
    }

    public EquipmentFiltering setGatewayIds(Set<GatewayIdFiltering> gatewayIds) {
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

    @OneToMany(targetEntity = TypeToReturnFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<TypeToReturnFiltering> getTypesToReturnIds() {
        return typesToReturnIds;
    }

    public EquipmentFiltering setTypesToReturnIds(Set<TypeToReturnFiltering> typesToReturnIds) {
        this.typesToReturnIds = typesToReturnIds;
        return this;
    }

    @OneToMany(targetEntity = NeighbourhoodIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "neighbourhoods",description = "neighbourhood id",refType = Neighbourhood.class)
    public Set<NeighbourhoodIdFiltering> getNeighbourhoodIds() {
        return neighbourhoodIds;
    }

    public EquipmentFiltering setNeighbourhoodIds(Set<NeighbourhoodIdFiltering> neighbourhoodIds) {
        this.neighbourhoodIds = neighbourhoodIds;
        return this;
    }

    @OneToMany(targetEntity = StreetIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "streetIds",description = "street ids",refType = Street.class)
    public Set<StreetIdFiltering> getStreetIds() {
        return streetIds;
    }

    public EquipmentFiltering setStreetIds(Set<StreetIdFiltering> streetIds) {
        this.streetIds = streetIds;
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

    @JsonIgnore
    @Transient

    public List<Neighbourhood> getNeighbourhoods() {
        return neighbourhoods;
    }

    public EquipmentFiltering setNeighbourhoods(List<Neighbourhood> neighbourhoods) {
        this.neighbourhoods = neighbourhoods;
        return this;
    }

    @JsonIgnore
    @Transient
    public List<Street> getStreets() {
        return streets;
    }


    public EquipmentFiltering setStreets(List<Street> streets) {
        this.streets = streets;
        return this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        for (GroupIdFiltering groupId : groupIds) {
            groupId.prepareForSave(this);
        }
        for (TypeToReturnFiltering typesToReturnId : typesToReturnIds) {
            typesToReturnId.prepareForSave(this);
        }
        for (ProductStatusIdFiltering productStatusId : productStatusIds) {
            productStatusId.prepareForSave(this);
        }
        for (GatewayIdFiltering gatewayId : gatewayIds) {
            gatewayId.prepareForSave(this);
        }
        for (EquipmentIdFiltering equipmentId : equipmentIds) {
            equipmentId.prepareForSave(this);
        }
        for (NeighbourhoodIdFiltering neighbourhoodId : neighbourhoodIds) {
            neighbourhoodId.prepareForSave(this);
        }
        for (StreetIdFiltering streetId : streetIds) {
            streetId.prepareForSave(this);
        }
        if(locationArea!=null){
            locationArea.prepareForSave(this);

        }

    }


}
