package com.flexicore.product.model;


import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BuildingFloorFiltering extends FilteringInformationHolder {

    @OneToMany(targetEntity = BuildingIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "building",description = "floors in building",refType = Building.class)
    private List<BuildingIdFiltering> buildingIdFilterings=new ArrayList<>();


    @OneToMany(targetEntity = BuildingIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "building",description = "floors in building",refType = Building.class)
    public List<BuildingIdFiltering> getBuildingIdFilterings() {
        return buildingIdFilterings;
    }

    public BuildingFloorFiltering setBuildingIdFilterings(List<BuildingIdFiltering> buildingIdFilterings) {
        this.buildingIdFilterings = buildingIdFilterings;
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
