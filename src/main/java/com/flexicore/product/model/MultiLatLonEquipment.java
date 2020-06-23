package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MultiLatLonEquipment extends Equipment {

    public MultiLatLonEquipment() {
    }

    public MultiLatLonEquipment(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    private boolean closedArea;
    @Lob
    private String contextString;


    @JsonIgnore
    @OneToMany(targetEntity = LatLon.class, mappedBy = "multiLatLonEquipment")
    private List<LatLon> latLons = new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = LatLon.class, mappedBy = "multiLatLonEquipment")
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

    @Lob
    public String getContextString() {
        return contextString;
    }

    public <T extends MultiLatLonEquipment> T setContextString(String contextString) {
        this.contextString = contextString;
        return (T) this;
    }
}
