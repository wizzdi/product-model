package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.BaseclassIdFiltering;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class ProductStatusFiltering extends FilteringInformationHolder {

    @OneToOne(targetEntity = BaseclassIdFiltering.class,mappedBy = "filteringInformationHolder",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @IdRefFieldInfo(displayName = "productTypeId",description = "product type to filter by",refType = ProductType.class,list = false)
    private BaseclassIdFiltering productTypeId;
    @JsonIgnore
    @Transient
    private ProductType productType;

    @OneToOne(targetEntity = BaseclassIdFiltering.class,mappedBy = "filteringInformationHolder",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    public BaseclassIdFiltering getProductTypeId() {
        return productTypeId;
    }

    public ProductStatusFiltering setProductTypeId(BaseclassIdFiltering productTypeId) {
        this.productTypeId = productTypeId;
        return this;
    }

    @Transient
    public ProductType getProductType() {
        return productType;
    }

    public ProductStatusFiltering setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }
}
