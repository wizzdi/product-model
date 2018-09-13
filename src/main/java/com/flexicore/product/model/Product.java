package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.flexicore.data.jsoncontainers.Views;
import com.flexicore.model.Baseclass;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
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
}
