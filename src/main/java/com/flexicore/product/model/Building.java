package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Building extends Equipment {
    static Building s_Singleton = new Building();
    public static Building s() {
        return s_Singleton;
    }


    @OneToMany(targetEntity = Equipment.class,mappedBy = "building")
    @JsonIgnore
    private List<Equipment> equipmentsInBuilding=new ArrayList<>();

    @OneToMany(targetEntity = BuildingFloor.class,mappedBy = "building")
    @JsonIgnore
    private List<BuildingFloor> floors=new ArrayList<>();


    @OneToMany(targetEntity = Equipment.class,mappedBy = "building")
    @JsonIgnore
    public List<Equipment> getEquipmentsInBuilding() {
        return equipmentsInBuilding;
    }

    public Building setEquipmentsInBuilding(List<Equipment> equipmentsInBuilding) {
        this.equipmentsInBuilding = equipmentsInBuilding;
        return this;
    }

    @OneToMany(targetEntity = BuildingFloor.class,mappedBy = "building")
    @JsonIgnore
    public List<BuildingFloor> getFloors() {
        return floors;
    }

    public Building setFloors(List<BuildingFloor> floors) {
        this.floors = floors;
        return this;
    }
}
