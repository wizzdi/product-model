package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class ProductStatus extends Baseclass {
    static ProductStatus s_Singleton = new ProductStatus();
    public static ProductStatus s() {
        return s_Singleton;
    }

    @OneToMany(targetEntity = ProductTypeToProductStatus.class,mappedBy = "rightside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private List<ProductTypeToProductStatus> productTypeToProductStatusList=new ArrayList<>();


    @OneToMany(targetEntity = ProductTypeToProductStatus.class,mappedBy = "rightside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    public List<ProductTypeToProductStatus> getProductTypeToProductStatusList() {
        return productTypeToProductStatusList;
    }

    public ProductStatus setProductTypeToProductStatusList(List<ProductTypeToProductStatus> productTypeToProductStatusList) {
        this.productTypeToProductStatusList = productTypeToProductStatusList;
        return this;
    }


    @OneToMany(targetEntity = ProductToStatus.class,mappedBy = "rightside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private List<ProductToStatus> productToStatusList=new ArrayList<>();


    @OneToMany(targetEntity = ProductToStatus.class,mappedBy = "rightside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    public List<ProductToStatus> getProductToStatusList() {
        return productToStatusList;
    }

    public ProductStatus setProductToStatusList(List<ProductToStatus> productToStatusList) {
        this.productToStatusList = productToStatusList;
        return this;
    }



}
