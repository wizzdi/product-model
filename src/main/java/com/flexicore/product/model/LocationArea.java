package com.flexicore.product.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LocationArea {

    @Id
    private String id;


    @ManyToOne(targetEntity = EquipmentFiltering.class)
    private EquipmentFiltering equipmentFiltering;

    private double lonStart;
    private double latStart;
    private double lonEnd;
    private double latEnd;


    public double getLonStart() {
        return lonStart;
    }

    public LocationArea setLonStart(double lonStart) {
        this.lonStart = lonStart;
        return this;
    }

    public double getLatStart() {
        return latStart;
    }

    public LocationArea setLatStart(double latStart) {
        this.latStart = latStart;
        return this;
    }

    public double getLonEnd() {
        return lonEnd;
    }

    public LocationArea setLonEnd(double lonEnd) {
        this.lonEnd = lonEnd;
        return this;
    }

    public double getLatEnd() {
        return latEnd;
    }

    public LocationArea setLatEnd(double latEnd) {
        this.latEnd = latEnd;
        return this;
    }

    @Id
    public String getId() {
        return id;
    }

    public LocationArea setId(String id) {
        this.id = id;
        return this;
    }

    @ManyToOne(targetEntity = EquipmentFiltering.class)
    public EquipmentFiltering getEquipmentFiltering() {
        return equipmentFiltering;
    }

    public LocationArea setEquipmentFiltering(EquipmentFiltering equipmentFiltering) {
        this.equipmentFiltering = equipmentFiltering;
        return this;
    }
}