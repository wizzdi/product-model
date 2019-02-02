package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.flexicore.annotations.sync.SyncOption;
import com.flexicore.data.jsoncontainers.Views;
import com.flexicore.model.Baseclass;
import com.flexicore.organization.model.SupplierToProduct;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;


@Entity
@SyncOption(continueSyncRecursionOnOneToMany = true)
public class Product extends Baseclass {
    static Product s_Singleton = new Product();

    public static Product s() {
        return s_Singleton;
    }

    @JsonView(Views.Unrefined.class)
    private String sku;
    @JsonView(Views.Unrefined.class)
    @OneToOne(targetEntity = Model.class)
    private Model model;

    @JsonView(Views.Unrefined.class)
    @ManyToOne(targetEntity = ProductType.class)
    private ProductType productType;




    @OneToMany(targetEntity = ProductToStatus.class,mappedBy = "leftside")
    @JsonIgnore
    private List<ProductToStatus> productToStatusList=new ArrayList<>();

    @OneToMany(targetEntity = SupplierToProduct.class,mappedBy = "rightside")
    @JsonIgnore
    private List<SupplierToProduct> supplierToProducts=new ArrayList<>();


    @SyncOption
    @OneToMany(targetEntity = ProductToStatus.class,mappedBy = "leftside")
    @JsonIgnore
    public List<ProductToStatus> getProductToStatusList() {
        return productToStatusList;
    }

    public Product setProductToStatusList(List<ProductToStatus> productToStatusList) {
        this.productToStatusList = productToStatusList;
        return this;
    }


    @JsonView(Views.Unrefined.class)
    public String getSku() {
        return sku;
    }

    public Product setSku(String sku) {
        this.sku = sku;
        return this;
    }

    @OneToOne(targetEntity = Model.class)
    @JsonView(Views.Unrefined.class)
    public Model getModel() {
        return model;
    }

    public Product setModel(Model model) {
        this.model = model;
        return this;
    }

    @JsonView(Views.Unrefined.class)
    @ManyToOne(targetEntity = ProductType.class)
    public ProductType getProductType() {
        return productType;
    }

    public Product setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    @OneToMany(targetEntity = SupplierToProduct.class,mappedBy = "rightside")
    @JsonIgnore
    public List<SupplierToProduct> getSupplierToProducts() {
        return supplierToProducts;
    }

    public Product setSupplierToProducts(List<SupplierToProduct> supplierToProducts) {
        this.supplierToProducts = supplierToProducts;
        return this;
    }

}
