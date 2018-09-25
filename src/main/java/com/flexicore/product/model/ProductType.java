package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class ProductType extends Baseclass {
    static ProductType s_Singleton = new ProductType();
    public static ProductType s() {
        return s_Singleton;
    }

    @ManyToOne(targetEntity = FileResource.class)
    private FileResource image;



    @OneToMany(targetEntity = ProductTypeToProductStatus.class,mappedBy = "leftside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private List<ProductTypeToProductStatus> productTypeToProductStatusList=new ArrayList<>();


    @OneToMany(targetEntity = ProductTypeToProductStatus.class,mappedBy = "leftside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    public List<ProductTypeToProductStatus> getProductTypeToProductStatusList() {
        return productTypeToProductStatusList;
    }

    public ProductType setProductTypeToProductStatusList(List<ProductTypeToProductStatus> productTypeToProductStatusList) {
        this.productTypeToProductStatusList = productTypeToProductStatusList;
        return this;
    }

    @ManyToOne(targetEntity = FileResource.class)
    public FileResource getImage() {
        return image;
    }

    public ProductType setImage(FileResource image) {
        this.image = image;
        return this;
    }
}
