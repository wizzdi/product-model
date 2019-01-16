package com.flexicore.organization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.product.model.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Manufacturer extends Organization {
    static Manufacturer s_Singleton = new Manufacturer();
    public static Manufacturer s() {
        return s_Singleton;
    }

    @OneToMany(targetEntity = Model.class,mappedBy = "manufacturer",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private List<Model> models=new ArrayList<>();

    @OneToMany(targetEntity = Model.class,mappedBy = "manufacturer",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    public List<Model> getModels() {
        return models;
    }

    public Manufacturer setModels(List<Model> models) {
        this.models = models;
        return this;
    }
}
