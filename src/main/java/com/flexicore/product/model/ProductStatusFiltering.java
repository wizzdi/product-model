package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.*;

@Entity
public class ProductStatusFiltering extends FilteringInformationHolder {

    @OneToOne(targetEntity = ProductTypeIdFiltering.class,mappedBy = "filteringInformationHolder",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @IdRefFieldInfo(displayName = "productTypeId",description = "product type to filter by",refType = ProductType.class,list = false)
    private ProductTypeIdFiltering productTypeId;
    @JsonIgnore
    @Transient
    private ProductType productType;

    @FieldInfo(description = "will only return product statuses that are used by the product that match this filter")
    @ManyToOne(targetEntity = EquipmentFiltering.class)
    private EquipmentFiltering equipmentFiltering;

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

    @ManyToOne(targetEntity = EquipmentFiltering.class)
    public EquipmentFiltering getEquipmentFiltering() {
        return equipmentFiltering;
    }

    public <T extends ProductStatusFiltering> T setEquipmentFiltering(EquipmentFiltering equipmentFiltering) {
        this.equipmentFiltering = equipmentFiltering;
        return (T) this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        if(productTypeId!=null){
            productTypeId.prepareForSave(this);
        }

    }
}
