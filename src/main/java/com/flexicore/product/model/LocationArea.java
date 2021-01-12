package com.flexicore.product.model;

import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.Baseclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LocationArea {

    @Id
    private String id;

    public LocationArea() {
        this.id= Baseclass.getBase64ID();
    }

    @OneToOne(targetEntity = EquipmentFiltering.class)
    private EquipmentFiltering equipmentFiltering;

    @FieldInfo(displayName = "lonStart",description = "longitude starts")
    private Double lonStart;
    @FieldInfo(displayName = "latStart",description = "latitude starts")

    private Double latStart;
    @FieldInfo(displayName = "lonEnd",description = "longitude ends")

    private Double lonEnd;
    @FieldInfo(displayName = "latEnd",description = "latitude ends")

    private Double latEnd;


    public Double getLonStart() {
        return lonStart;
    }

    public LocationArea setLonStart(Double lonStart) {
        this.lonStart = lonStart;
        return this;
    }

    public Double getLatStart() {
        return latStart;
    }

    public LocationArea setLatStart(Double latStart) {
        this.latStart = latStart;
        return this;
    }

    public Double getLonEnd() {
        return lonEnd;
    }

    public LocationArea setLonEnd(Double lonEnd) {
        this.lonEnd = lonEnd;
        return this;
    }

    public Double getLatEnd() {
        return latEnd;
    }

    public LocationArea setLatEnd(Double latEnd) {
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

    @OneToOne(targetEntity = EquipmentFiltering.class)
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
