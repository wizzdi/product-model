package com.flexicore.product.model;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class GatewayToEquipment extends Baselink {
    static GatewayToEquipment s_Singleton = new GatewayToEquipment();
    public static GatewayToEquipment s() {
        return s_Singleton;
    }




    @Override
    @ManyToOne(targetEntity =Gateway.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public Gateway getLeftside() {
        return (Gateway) super.getLeftside();
    }

    public void setLeftside(Gateway leftside) {
        super.setLeftside(leftside);
    }

    @Override
    public void setLeftside(Baseclass leftside) {
        super.setLeftside(leftside);
    }

    @Override
    @ManyToOne(targetEntity =Equipment.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public Equipment getRightside() {
        return (Equipment) super.getRightside();
    }

    public void setRightside(Equipment rightside) {
        super.setRightside(rightside);
    }

    @Override
    public void setRightside(Baseclass rightside) {
        super.setRightside(rightside);
    }
}
