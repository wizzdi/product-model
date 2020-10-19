package com.flexicore.product.model;

import com.flexicore.model.nosql.BaseclassNoSQL;

import java.util.Date;

public class EquipmentLocation extends BaseclassNoSQL {

    private Date dateAtLocation;
    private double lat;
    private double lon;
    private double x;
    private double y;
    private String buildingFloorId;
    private String roomId;
    private String equipmentId;

    public Date getDateAtLocation() {
        return dateAtLocation;
    }

    public <T extends EquipmentLocation> T setDateAtLocation(Date dateAtLocation) {
        this.dateAtLocation = dateAtLocation;
        return (T) this;
    }

    public double getLat() {
        return lat;
    }

    public <T extends EquipmentLocation> T setLat(double lat) {
        this.lat = lat;
        return (T) this;
    }

    public double getLon() {
        return lon;
    }

    public <T extends EquipmentLocation> T setLon(double lon) {
        this.lon = lon;
        return (T) this;
    }

    public double getX() {
        return x;
    }

    public <T extends EquipmentLocation> T setX(double x) {
        this.x = x;
        return (T) this;
    }

    public double getY() {
        return y;
    }

    public <T extends EquipmentLocation> T setY(double y) {
        this.y = y;
        return (T) this;
    }

    public String getBuildingFloorId() {
        return buildingFloorId;
    }

    public <T extends EquipmentLocation> T setBuildingFloorId(String buildingFloorId) {
        this.buildingFloorId = buildingFloorId;
        return (T) this;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public <T extends EquipmentLocation> T setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
        return (T) this;
    }

    public String getRoomId() {
        return roomId;
    }

    public <T extends EquipmentLocation> T setRoomId(String roomId) {
        this.roomId = roomId;
        return (T) this;
    }
}
