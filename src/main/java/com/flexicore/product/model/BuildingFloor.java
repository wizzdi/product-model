package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class BuildingFloor extends Baseclass {
    static BuildingFloor s_Singleton = new BuildingFloor();

    public static BuildingFloor s() {
        return s_Singleton;
    }

    public BuildingFloor() {
    }

    public BuildingFloor(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @OneToMany(targetEntity = Equipment.class,mappedBy = "buildingFloor")
    @JsonIgnore
    private List<Equipment> equipmentsInBuilding=new ArrayList<>();

    private int floorNumber;
    @ManyToOne(targetEntity = Building.class)
    private Building building;

    @ManyToOne(targetEntity = FileResource.class)
    private FileResource diagram;

    @ManyToOne(targetEntity = FileResource.class)
    private FileResource diagram3D;

    public int getFloorNumber() {
        return floorNumber;
    }

    @ManyToOne(targetEntity = FileResource.class)
    public BuildingFloor setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
        return this;
    }

    @ManyToOne(targetEntity = FileResource.class)
    public FileResource getDiagram() {
        return diagram;
    }

    public BuildingFloor setDiagram(FileResource diagram) {
        this.diagram = diagram;
        return this;
    }

    @ManyToOne(targetEntity = Building.class)
    public Building getBuilding() {
        return building;
    }

    public BuildingFloor setBuilding(Building building) {
        this.building = building;
        return this;
    }

    @OneToMany(targetEntity = Equipment.class,mappedBy = "buildingFloor")
    @JsonIgnore
    public List<Equipment> getEquipmentsInBuilding() {
        return equipmentsInBuilding;
    }

    public BuildingFloor setEquipmentsInBuilding(List<Equipment> equipmentsInBuilding) {
        this.equipmentsInBuilding = equipmentsInBuilding;
        return this;
    }

    @ManyToOne(targetEntity = FileResource.class)
    public FileResource getDiagram3D() {
        return diagram3D;
    }

    public <T extends BuildingFloor> T setDiagram3D(FileResource diagram3D) {
        this.diagram3D = diagram3D;
        return (T) this;
    }
}
