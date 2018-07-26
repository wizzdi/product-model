package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class EquipmentGroup extends Product {
    static EquipmentGroup s_Singleton = new EquipmentGroup();
    public static EquipmentGroup s() {
        return s_Singleton;
    }


    @OneToMany(targetEntity = EquipmentToGroup.class,mappedBy = "rightside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private List<EquipmentToGroup> equipmentToGroupList=new ArrayList<>();


    @OneToMany(targetEntity = EquipmentToGroup.class,mappedBy = "rightside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    public List<EquipmentToGroup> equipmentToGroupList() {
        return equipmentToGroupList;
    }



}
