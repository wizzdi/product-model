package com.flexicore.product.model;

import com.flexicore.model.Baseclass;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity
public class EquipmentType extends ProductType {
    static EquipmentType s_Singleton = new EquipmentType();
    public static EquipmentType s() {
        return s_Singleton;
    }



}
