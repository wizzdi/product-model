package com.flexicore.organization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.product.model.GatewayToEquipment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Organization extends Baseclass {
    static Organization s_Singleton = new Organization();

    public static Organization s() {
        return s_Singleton;
    }

}
