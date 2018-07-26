package com.flexicore.product.model;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class EquipmentToGroup extends Baselink {
    static EquipmentToGroup s_Singleton = new EquipmentToGroup();
    public static EquipmentToGroup s() {
        return s_Singleton;
    }




    @Override
    @ManyToOne(targetEntity =Equipment.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public Equipment getLeftside() {
        return (Equipment) super.getLeftside();
    }

    public void setLeftside(Equipment leftside) {
        super.setLeftside(leftside);
    }

    @Override
    public void setLeftside(Baseclass leftside) {
        super.setLeftside(leftside);
    }

    @Override
    @ManyToOne(targetEntity =EquipmentGroup.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public EquipmentGroup getRightside() {
        return (EquipmentGroup) super.getRightside();
    }

    public void setRightside(EquipmentGroup rightside) {
        super.setRightside(rightside);
    }

    @Override
    public void setRightside(Baseclass rightside) {
        super.setRightside(rightside);
    }
}
