package com.wizzdi.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.SecuredBasic;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductType extends SecuredBasic {

    @JsonIgnore
    @OneToMany(targetEntity = Feature.class,mappedBy = "productType")
    private List<Feature> features=new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = Model.class,mappedBy = "productType")
    private List<Model> models=new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = Feature.class,mappedBy = "productType")
    public List<Feature> getFeatures() {
        return features;
    }

    public <T extends ProductType> T setFeatures(List<Feature> features) {
        this.features = features;
        return (T) this;
    }

    @JsonIgnore
    @OneToMany(targetEntity = Model.class,mappedBy = "productType")
    public List<Model> getModels() {
        return models;
    }

    public <T extends ProductType> T setModels(List<Model> models) {
        this.models = models;
        return (T) this;
    }
}
