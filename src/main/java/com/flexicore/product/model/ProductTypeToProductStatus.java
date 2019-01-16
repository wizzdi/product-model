package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;
import com.flexicore.model.FileResource;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class ProductTypeToProductStatus extends Baselink {
    static ProductTypeToProductStatus s_Singleton = new ProductTypeToProductStatus();
    public static ProductTypeToProductStatus s() {
        return s_Singleton;
    }

    @ManyToOne(targetEntity = FileResource.class)
    @JsonIgnore
    private FileResource image;



    @Override
    @ManyToOne(targetEntity =ProductType.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public ProductType getLeftside() {
        return (ProductType) super.getLeftside();
    }

    public void setLeftside(ProductType leftside) {
        super.setLeftside(leftside);
    }


    @Override
    @ManyToOne(targetEntity =ProductStatus.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public ProductStatus getRightside() {
        return (ProductStatus) super.getRightside();
    }

    public void setRightside(ProductStatus rightside) {
        super.setRightside(rightside);
    }

    @ManyToOne(targetEntity = FileResource.class)
    @JsonIgnore
    public FileResource getImage() {
        return image;
    }

    public ProductTypeToProductStatus setImage(FileResource image) {
        this.image = image;
        return this;
    }
}
