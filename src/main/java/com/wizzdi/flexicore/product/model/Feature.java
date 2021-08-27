package com.wizzdi.flexicore.product.model;

import com.flexicore.model.SecuredBasic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Feature extends SecuredBasic {

    @ManyToOne(targetEntity = ProductType.class)
    private ProductType productType;

    @ManyToOne(targetEntity = ProductType.class)
    public ProductType getProductType() {
        return productType;
    }

    public <T extends Feature> T setProductType(ProductType productType) {
        this.productType = productType;
        return (T) this;
    }
}
