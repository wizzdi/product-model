package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.organization.model.Manufacturer;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Model extends Baseclass {
    static Model s_Singleton = new Model();

    public static Model s() {
        return s_Singleton;
    }

    private double weight;

    @ManyToOne(targetEntity = Manufacturer.class)
    private Manufacturer manufacturer;

    @JsonIgnore
    @OneToMany(targetEntity = Product.class, mappedBy = "model")
    private List<Product> products=new ArrayList<>();

    public double getWeight() {
        return weight;
    }

    public Model setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    @JsonIgnore
    @OneToMany(targetEntity = Product.class, mappedBy = "model")
    public List<Product> getProducts() {
        return products;
    }

    public Model setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    @ManyToOne(targetEntity = Manufacturer.class)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Model setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }
}
