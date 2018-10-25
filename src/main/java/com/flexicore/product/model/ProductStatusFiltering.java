package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class ProductStatusFiltering extends FilteringInformationHolder {

    @OneToOne(targetEntity = ProductTypeIdFiltering.class,mappedBy = "filteringInformationHolder",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @IdRefFieldInfo(displayName = "productTypeId",description = "product type to filter by",refType = ProductType.class,list = false)
    private ProductTypeIdFiltering productTypeId;
    @JsonIgnore
    @Transient
    private ProductType productType;

    @OneToOne(targetEntity = ProductTypeIdFiltering.class,mappedBy = "filteringInformationHolder",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    public ProductTypeIdFiltering getProductTypeId() {
        return productTypeId;
    }

    public ProductStatusFiltering setProductTypeId(ProductTypeIdFiltering productTypeId) {
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

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        if(productTypeId!=null){
            productTypeId.prepareForSave(this);

        }
    }
}
