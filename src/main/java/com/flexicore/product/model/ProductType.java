package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;
import com.flexicore.security.SecurityContext;

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

    public ProductType() {
    }

    public ProductType(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @JsonIgnore
    @OneToMany(targetEntity = Product.class,mappedBy = "productType")
    private List<Product> products=new ArrayList<>();

    @ManyToOne(targetEntity = FileResource.class)
    private FileResource image;

    @ManyToOne(targetEntity = FileResource.class)
    private FileResource diagram3D;


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

    @ManyToOne(targetEntity = FileResource.class)
    public FileResource getDiagram3D() {
        return diagram3D;
    }

    public <T extends ProductType> T setDiagram3D(FileResource diagram3D) {
        this.diagram3D = diagram3D;
        return (T) this;
    }

    @JsonIgnore
    @OneToMany(targetEntity = Product.class,mappedBy = "productType")
    public List<Product> getProducts() {
        return products;
    }

    public <T extends ProductType> T setProducts(List<Product> products) {
        this.products = products;
        return (T) this;
    }
}
