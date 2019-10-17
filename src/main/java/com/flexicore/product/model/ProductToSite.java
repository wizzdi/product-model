package com.flexicore.product.model;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;
import com.flexicore.organization.model.Consumer;
import com.flexicore.organization.model.ConsumerToOrganization;
import com.flexicore.organization.model.Organization;
import com.flexicore.organization.model.Site;
import com.flexicore.security.SecurityContext;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class ProductToSite extends Baselink {
    static ProductToSite s_Singleton = new ProductToSite();
    public static ProductToSite s() {
        return s_Singleton;
    }


    public ProductToSite() {
    }

    public ProductToSite(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @Override
    @ManyToOne(targetEntity = Product.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public Product getLeftside() {
        return (Product) super.getLeftside();
    }

    public void setLeftside(Product leftside) {
        super.setLeftside(leftside);
    }

    @Override
    public void setLeftside(Baseclass leftside) {
        super.setLeftside(leftside);
    }

    @Override
    @ManyToOne(targetEntity = Site.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public Site getRightside() {
        return (Site) super.getRightside();
    }

    public void setRightside(Site rightside) {
        super.setRightside(rightside);
    }

    @Override
    public void setRightside(Baseclass rightside) {
        super.setRightside(rightside);
    }


}
