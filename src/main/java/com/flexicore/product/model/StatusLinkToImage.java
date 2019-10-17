package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class StatusLinkToImage extends Baseclass {
    static StatusLinkToImage s_Singleton = new StatusLinkToImage();
    public static StatusLinkToImage s() {
        return s_Singleton;
    }

    @ManyToOne(targetEntity = FileResource.class)
    private FileResource image;
    @ManyToOne(targetEntity = ProductTypeToProductStatus.class)
    private ProductTypeToProductStatus statusLink;

    public StatusLinkToImage() {
    }

    public StatusLinkToImage(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @ManyToOne(targetEntity = FileResource.class)
    public FileResource getImage() {
        return image;
    }

    public <T extends StatusLinkToImage> T setImage(FileResource image) {
        this.image = image;
        return (T) this;
    }

    @ManyToOne(targetEntity = ProductTypeToProductStatus.class)
    public ProductTypeToProductStatus getStatusLink() {
        return statusLink;
    }

    public <T extends StatusLinkToImage> T setStatusLink(ProductTypeToProductStatus statusLink) {
        this.statusLink = statusLink;
        return (T) this;
    }
}
