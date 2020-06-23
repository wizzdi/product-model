package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;
import com.flexicore.security.SecurityContext;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class EquipmentToGroup extends Baselink {


    public EquipmentToGroup() {
    }

    public EquipmentToGroup(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @Override
    @ManyToOne(targetEntity =Equipment.class, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    public Equipment getLeftside() {
        return (Equipment) super.getLeftside();
    }

    @JsonIgnore
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

    @JsonIgnore
    public void setRightside(EquipmentGroup rightside) {
        super.setRightside(rightside);
    }

    @Override
    public void setRightside(Baseclass rightside) {
        super.setRightside(rightside);
    }
}
