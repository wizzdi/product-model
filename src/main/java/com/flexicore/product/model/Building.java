package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.security.SecurityContext;

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


    public Building() {
    }

    public Building(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @OneToMany(targetEntity = BuildingFloor.class,mappedBy = "building")
    @JsonIgnore
    private List<BuildingFloor> floors=new ArrayList<>();



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
