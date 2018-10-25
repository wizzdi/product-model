package com.flexicore.product.model;


import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.model.BaseclassLongFiltering;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GatewayFiltering extends EquipmentFiltering {

    @OneToMany(targetEntity = GatewayConsoleIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @ListFieldInfo(description = "consoleIds",displayName = "list of console ids",listType = BaseclassLongFiltering.class)
    private Set<GatewayConsoleIdFiltering> consoleIds=new HashSet<>();

    @OneToMany(targetEntity = GatewayConsoleIdFiltering.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<GatewayConsoleIdFiltering> getConsoleIds() {
        return consoleIds;
    }

    public GatewayFiltering setConsoleIds(Set<GatewayConsoleIdFiltering> consoleIds) {
        this.consoleIds = consoleIds;
        return this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        for (GatewayConsoleIdFiltering consoleId : consoleIds) {
            consoleId.prepareForSave(this);
        }
    }
}
