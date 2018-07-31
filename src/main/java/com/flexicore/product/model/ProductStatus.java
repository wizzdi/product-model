package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Entity
public class ProductStatus extends Baseclass {
    static ProductStatus s_Singleton = new ProductStatus();
    public static ProductStatus s() {
        return s_Singleton;
    }

    @ManyToOne(targetEntity = FileResource.class)
    private FileResource image;

    private int priority;

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

    @ManyToOne(targetEntity = FileResource.class)
    public FileResource getImage() {
        return image;
    }

    public ProductStatus setImage(FileResource image) {
        this.image = image;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public ProductStatus setPriority(int priority) {
        this.priority = priority;
        return this;
    }
}
