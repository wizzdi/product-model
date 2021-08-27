package com.wizzdi.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.SecuredBasic;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manufacturer extends SecuredBasic {

    @JsonIgnore
    @OneToMany(targetEntity = Model.class,mappedBy = "manufacturer")
    private List<Model> models=new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = Model.class,mappedBy = "manufacturer")
    public List<Model> getModels() {
        return models;
    }

    public <T extends Manufacturer> T setModels(List<Model> models) {
        this.models = models;
        return (T) this;
    }
}
