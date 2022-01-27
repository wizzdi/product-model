package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;
import com.flexicore.security.SecurityContext;
import com.flexicore.security.SecurityContextBase;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class ProductToStatus extends Baselink {

    private boolean enabled;


    public ProductToStatus() {
    }

    public ProductToStatus(String name, SecurityContextBase securityContext) {
        super(name, securityContext);
    }

    @Override
    @ManyToOne(targetEntity =Product.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public Product getLeftside() {
        return (Product) super.getLeftside();
    }

    @JsonIgnore
    public void setLeftside(Product leftside) {
        super.setLeftside(leftside);
    }


    @Override
    @ManyToOne(targetEntity =ProductStatus.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public ProductStatus getRightside() {
        return (ProductStatus) super.getRightside();
    }

    @JsonIgnore
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
