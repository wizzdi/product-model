package com.wizzdi.flexicore.product.model;

import com.flexicore.model.SecuredBasic;
import com.wizzdi.flexicore.pricing.model.product.PricedProduct;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Product extends SecuredBasic {

    private String serialNumber;
    @ManyToOne(targetEntity = Model.class)
    private Model model;
    @ManyToOne(targetEntity = PricedProduct.class)
    private PricedProduct pricedProduct;

    public String getSerialNumber() {
        return serialNumber;
    }

    public <T extends Product> T setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return (T) this;
    }

    @ManyToOne(targetEntity = Model.class)
    public Model getModel() {
        return model;
    }

    public <T extends Product> T setModel(Model model) {
        this.model = model;
        return (T) this;
    }

    @ManyToOne(targetEntity = PricedProduct.class)
    public PricedProduct getPricedProduct() {
        return pricedProduct;
    }

    public <T extends Product> T setPricedProduct(PricedProduct pricedProduct) {
        this.pricedProduct = pricedProduct;
        return (T) this;
    }
}
