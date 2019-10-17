package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.organization.model.Manufacturer;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class LatLon extends Baseclass {
    static LatLon s_Singleton = new LatLon();

    public static LatLon s() {
        return s_Singleton;
    }


    private int ordinal;
    private double lat;
    private double lon;
    @ManyToOne(targetEntity = MultiLatLonEquipment.class)
    private MultiLatLonEquipment multiLatLonEquipment;


    public LatLon() {
    }

    public LatLon(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }
    public double getLat() {
        return lat;
    }

    public <T extends LatLon> T setLat(double lat) {
        this.lat = lat;
        return (T) this;
    }

    public double getLon() {
        return lon;
    }

    public <T extends LatLon> T setLon(double lon) {
        this.lon = lon;
        return (T) this;
    }

    @ManyToOne(targetEntity = MultiLatLonEquipment.class)
    public MultiLatLonEquipment getMultiLatLonEquipment() {
        return multiLatLonEquipment;
    }

    public <T extends LatLon> T setMultiLatLonEquipment(MultiLatLonEquipment multiLatLonEquipment) {
        this.multiLatLonEquipment = multiLatLonEquipment;
        return (T) this;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public <T extends LatLon> T setOrdinal(int ordinal) {
        this.ordinal = ordinal;
        return (T) this;
    }


}
