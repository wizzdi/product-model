package com.flexicore.product.model;

import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.Baseclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LocationArea {

    @Id
    private String id;

    public LocationArea() {
        this.id= Baseclass.getBase64ID();
    }

    @ManyToOne(targetEntity = EquipmentFiltering.class)
    private EquipmentFiltering equipmentFiltering;

    @FieldInfo(displayName = "lonStart",description = "longitude starts")
    private double lonStart;
    @FieldInfo(displayName = "latStart",description = "latitude starts")

    private double latStart;
    @FieldInfo(displayName = "lonEnd",description = "longitude ends")

    private double lonEnd;
    @FieldInfo(displayName = "latEnd",description = "latitude ends")

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

    public void prepareForSave(EquipmentFiltering equipmentFiltering) {
        this.equipmentFiltering=equipmentFiltering;
    }
}
