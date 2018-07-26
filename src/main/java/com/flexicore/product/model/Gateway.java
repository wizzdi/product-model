package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Gateway extends Equipment {
    static Gateway s_Singleton = new Gateway();

    public static Gateway s() {
        return s_Singleton;
    }

    @OneToMany(targetEntity = GatewayToEquipment.class,mappedBy = "leftside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private List<GatewayToEquipment> gatewayToEquipmentList=new ArrayList<>();


    @OneToMany(targetEntity = GatewayToEquipment.class,mappedBy = "leftside",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    public List<GatewayToEquipment> getGatewayToEquipmentList() {
        return gatewayToEquipmentList;
    }

    public Gateway setGatewayToEquipmentList(List<GatewayToEquipment> gatewayToEquipmentList) {
        this.gatewayToEquipmentList = gatewayToEquipmentList;
        return this;
    }
}
