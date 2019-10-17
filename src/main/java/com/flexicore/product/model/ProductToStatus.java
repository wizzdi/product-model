package com.flexicore.product.model;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;
import com.flexicore.security.SecurityContext;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class ProductToStatus extends Baselink {
    static ProductToStatus s_Singleton = new ProductToStatus();
    public static ProductToStatus s() {
        return s_Singleton;
    }

    private boolean enabled;


    public ProductToStatus() {
    }

    public ProductToStatus(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @Override
    @ManyToOne(targetEntity =Product.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public Product getLeftside() {
        return (Product) super.getLeftside();
    }

    public void setLeftside(Product leftside) {
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


    public boolean isEnabled() {
        return enabled;
    }

    public ProductToStatus setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
