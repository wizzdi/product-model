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
public class ProductFiltering extends FilteringInformationHolder {


    public ProductFiltering() {
    }

    public ProductFiltering(ProductFiltering other) {
        super(other);
        this.productTypeId = other.productTypeId;
        this.productType = other.productType;
        this.productStatusIds = other.productStatusIds;
        this.productStatusList = other.productStatusList;
    }

    @OneToOne(targetEntity = ProductTypeIdFiltering.class)
    @IdRefFieldInfo(displayName = "productTypeId",description = "product type id",refType = ProductType.class,list = false)
    private ProductTypeIdFiltering productTypeId;

    @JsonIgnore
    @Transient
    private ProductType productType;
    @OneToMany(targetEntity = ProductStatusIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "productStatusIds",description = "equipment with status",refType = ProductStatus.class)
    private Set<ProductStatusIdFiltering> productStatusIds = new HashSet<>();
    @JsonIgnore
    @Transient
    private List<ProductStatus> productStatusList = new ArrayList<>();




    @OneToOne(targetEntity = ProductTypeIdFiltering.class)
    public ProductTypeIdFiltering getProductTypeId() {
        return productTypeId;
    }

    public ProductFiltering setProductTypeId(ProductTypeIdFiltering productTypeId) {
        this.productTypeId = productTypeId;
        return this;
    }

    @JsonIgnore
    @Transient
    public ProductType getProductType() {
        return productType;
    }

    public ProductFiltering setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    @OneToMany(targetEntity = ProductStatusIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<ProductStatusIdFiltering> getProductStatusIds() {
        return productStatusIds;
    }

    public ProductFiltering setProductStatusIds(Set<ProductStatusIdFiltering> productStatusIds) {
        this.productStatusIds = productStatusIds;
        return this;
    }

    @JsonIgnore
    @Transient
    public List<ProductStatus> getProductStatusList() {
        return productStatusList;
    }

    public ProductFiltering setProductStatusList(List<ProductStatus> productStatusList) {
        this.productStatusList = productStatusList;
        return this;
    }


    @Override
    public void prepareForSave() {
        super.prepareForSave();


        for (ProductStatusIdFiltering productStatusId : productStatusIds) {
            productStatusId.prepareForSave(this);
        }


    }


}
