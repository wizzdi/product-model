package com.flexicore.product.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class BuildingFloorFiltering extends FilteringInformationHolder {

    @OneToMany(targetEntity = BuildingIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "building",description = "floors in building",refType = Building.class)
    private Set<BuildingIdFiltering> buildingIdFilterings=new HashSet<>();

    @JsonIgnore
    @Transient
    private List<Building> buildings;


    @OneToMany(targetEntity = BuildingIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "building",description = "floors in building",refType = Building.class)
    public Set<BuildingIdFiltering> getBuildingIdFilterings() {
        return buildingIdFilterings;
    }

    public BuildingFloorFiltering setBuildingIdFilterings(Set<BuildingIdFiltering> buildingIdFilterings) {
        this.buildingIdFilterings = buildingIdFilterings;
        return this;
    }

    @Transient
    @JsonIgnore
    public List<Building> getBuildings() {
        return buildings;
    }

    public BuildingFloorFiltering setBuildings(List<Building> buildings) {
        this.buildings = buildings;
        return this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        for (BuildingIdFiltering buildingIdFiltering : buildingIdFilterings) {
            buildingIdFiltering.prepareForSave(this);
        }

    }
}
