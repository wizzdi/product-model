package com.flexicore.product.model;


import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.Entity;

@Entity
public class ProductTypeFiltering extends FilteringInformationHolder {


    @FieldInfo(description = "will only return product types that are actively being used")
    private boolean haveActualInstances;


    public boolean isHaveActualInstances() {
        return haveActualInstances;
    }

    public <T extends ProductTypeFiltering> T setHaveActualInstances(boolean haveActualInstances) {
        this.haveActualInstances = haveActualInstances;
        return (T) this;
    }
}
