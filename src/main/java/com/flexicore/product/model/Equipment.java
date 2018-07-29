package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
    private String geoHash1;
    private String geoHash2;
    private String geoHash3;
    private String geoHash4;
    private String geoHash5;
    private String geoHash6;
    private String geoHash7;
    private String geoHash8;
    private String geoHash9;
    private String geoHash10;
    private String geoHash11;
    private String geoHash12;

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

    public String getGeoHash1() {
        return geoHash1;
    }

    public Equipment setGeoHash1(String geoHash1) {
        this.geoHash1 = geoHash1;
        return this;
    }


    public String getGeoHash2() {
        return geoHash2;
    }

    public Equipment setGeoHash2(String geoHash2) {
        this.geoHash2 = geoHash2;
        return this;
    }

    public String getGeoHash3() {
        return geoHash3;
    }

    public Equipment setGeoHash3(String geoHash3) {
        this.geoHash3 = geoHash3;
        return this;
    }

    public String getGeoHash4() {
        return geoHash4;
    }

    public Equipment setGeoHash4(String geoHash4) {
        this.geoHash4 = geoHash4;
        return this;
    }

    public String getGeoHash5() {
        return geoHash5;
    }

    public Equipment setGeoHash5(String geoHash5) {
        this.geoHash5 = geoHash5;
        return this;
    }

    public String getGeoHash6() {
        return geoHash6;
    }

    public Equipment setGeoHash6(String geoHash6) {
        this.geoHash6 = geoHash6;
        return this;
    }

    public String getGeoHash7() {
        return geoHash7;
    }

    public Equipment setGeoHash7(String geoHash7) {
        this.geoHash7 = geoHash7;
        return this;
    }

    public String getGeoHash8() {
        return geoHash8;
    }

    public Equipment setGeoHash8(String geoHash8) {
        this.geoHash8 = geoHash8;
        return this;
    }

    public String getGeoHash9() {
        return geoHash9;
    }

    public Equipment setGeoHash9(String geoHash9) {
        this.geoHash9 = geoHash9;
        return this;
    }

    public String getGeoHash10() {
        return geoHash10;
    }

    public Equipment setGeoHash10(String geoHash10) {
        this.geoHash10 = geoHash10;
        return this;
    }

    public String getGeoHash11() {
        return geoHash11;
    }

    public Equipment setGeoHash11(String geoHash11) {
        this.geoHash11 = geoHash11;
        return this;
    }

    public String getGeoHash12() {
        return geoHash12;
    }

    public Equipment setGeoHash12(String geoHash12) {
        this.geoHash12 = geoHash12;
        return this;
    }
}
