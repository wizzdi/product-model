package com.flexicore.product.model;

import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class BuildingFloor extends Baseclass {
    static BuildingFloor s_Singleton = new BuildingFloor();
    public static BuildingFloor s() {
        return s_Singleton;
    }


   private int floorNumber;
    @ManyToOne(targetEntity = Building.class)
    private Building building;

    @ManyToOne(targetEntity = FileResource.class)
    private FileResource diagram;

    public int getFloorNumber() {
        return floorNumber;
    }

    @ManyToOne(targetEntity = FileResource.class)
    public BuildingFloor setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
        return this;
    }

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
}
