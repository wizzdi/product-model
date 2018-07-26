package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Equipment extends Product {
    static Equipment s_Singleton = new Equipment();
    public static Equipment s() {
        return s_Singleton;
    }
    static{
        registerSingletone(s_Singleton);
    }


    private double lat;
    private double lon;
    private String serial;
    private LocalDateTime warrantyExpiration;

    @OneToMany(targetEntity = GatewayToEquipment.class,mappedBy = "rightside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private List<GatewayToEquipment> gatewayToEquipmentList=new ArrayList<>();


    @OneToMany(targetEntity = GatewayToEquipment.class,mappedBy = "rightside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    public List<GatewayToEquipment> getGatewayToEquipmentList() {
        return gatewayToEquipmentList;
    }


    @OneToMany(targetEntity = EquipmentToGroup.class,mappedBy = "leftside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private List<EquipmentToGroup> equipmentToGroupList=new ArrayList<>();


    @OneToMany(targetEntity = EquipmentToGroup.class,mappedBy = "leftside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    public List<EquipmentToGroup> getEquipmentToGroupList() {
        return equipmentToGroupList;
    }

    public Equipment setGatewayToEquipmentList(List<GatewayToEquipment> gatewayToEquipmentList) {
        this.gatewayToEquipmentList = gatewayToEquipmentList;
        return this;
    }

    public String getSerial() {
        return serial;
    }

    public Equipment setSerial(String serial) {
        this.serial = serial;
        return this;
    }

    public LocalDateTime getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public Equipment setWarrantyExpiration(LocalDateTime warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public Equipment setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLon() {
        return lon;
    }

    public Equipment setLon(double lon) {
        this.lon = lon;
        return this;
    }

    public Equipment setEquipmentToGroupList(List<EquipmentToGroup> equipmentToGroupList) {
        this.equipmentToGroupList = equipmentToGroupList;
        return this;
    }
}
