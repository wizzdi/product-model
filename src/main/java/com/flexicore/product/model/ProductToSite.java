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
public class ProductToSite extends Baseclass {

    @ManyToOne(targetEntity = Product.class)
    private Product product;
    @ManyToOne(targetEntity = Site.class)
    private Site site;

    public ProductToSite() {
    }

    public ProductToSite(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }


    @ManyToOne(targetEntity = Product.class)
    public Product getProduct() {
        return product;
    }

    public <T extends ProductToSite> T setProduct(Product product) {
        this.product = product;
        return (T) this;
    }

    @ManyToOne(targetEntity = Site.class)
    public Site getSite() {
        return site;
    }

    public <T extends ProductToSite> T setSite(Site site) {
        this.site = site;
        return (T) this;
    }
}
