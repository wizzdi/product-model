package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MultiLatLonEquipment extends Equipment {
    private static MultiLatLonEquipment s_Singleton = new MultiLatLonEquipment();
    public static MultiLatLonEquipment s() { return s_Singleton; }

    private boolean closedArea;


    @JsonIgnore
    @OneToMany(targetEntity = LatLon.class,mappedBy = "multiLatLonEquipment")
    private List<LatLon> latLons=new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = LatLon.class,mappedBy = "multiLatLonEquipment")
    public List<LatLon> getLatLons() {
        return latLons;
    }

    public <T extends MultiLatLonEquipment> T setLatLons(List<LatLon> latLons) {
        this.latLons = latLons;
        return (T) this;
    }

    public boolean isClosedArea() {
        return closedArea;
    }

    public <T extends MultiLatLonEquipment> T setClosedArea(boolean closedArea) {
        this.closedArea = closedArea;
        return (T) this;
    }
}
