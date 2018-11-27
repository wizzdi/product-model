package com.flexicore.product.model;


import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.product.model.GatewayFiltering;
import javax.persistence.Entity;

@Entity
public class FlexiCoreGatewayFiltering extends GatewayFiltering {

    @FieldInfo(description = "consoleIds",displayName = "list of console ids")
    private String basePathLike;


    public String getBasePathLike() {
        return basePathLike;
    }

    public FlexiCoreGatewayFiltering setBasePathLike(String basePathLike) {
        this.basePathLike = basePathLike;
        return this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();

    }
}
