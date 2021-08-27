package com.wizzdi.flexicore.product.model;

import com.flexicore.model.SecuredBasic;
import com.wizzdi.flexicore.pricing.model.product.PricedProduct;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Model extends SecuredBasic {

    @ManyToOne(targetEntity = Manufacturer.class)
    private Manufacturer manufacturer;
    @ManyToOne(targetEntity = ProductType.class)
    private ProductType productType;
    @ManyToOne(targetEntity = PricedProduct.class)
    private PricedProduct pricedProduct;
    private String sku;

    public String getSku() {
        return sku;
    }

    public <T extends Model> T setSku(String sku) {
        this.sku = sku;
        return (T) this;
    }

    @ManyToOne(targetEntity = Manufacturer.class)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public <T extends Model> T setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return (T) this;
    }

    @ManyToOne(targetEntity = ProductType.class)
    public ProductType getProductType() {
        return productType;
    }

    public <T extends Model> T setProductType(ProductType productType) {
        this.productType = productType;
        return (T) this;
    }

    @ManyToOne(targetEntity = PricedProduct.class)
    public PricedProduct getPricedProduct() {
        return pricedProduct;
    }

    public <T extends Model> T setPricedProduct(PricedProduct pricedProduct) {
        this.pricedProduct = pricedProduct;
        return (T) this;
    }
}
