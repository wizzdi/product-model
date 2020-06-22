package com.flexicore.product.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.iot.model.FlexiCoreServer;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class FlexiCoreGatewayFiltering extends GatewayFiltering {

    @FieldInfo(description = "consoleIds",displayName = "list of console ids")
    private String basePathLike;

    @JsonIgnore
    @Transient
    private FlexiCoreServer flexiCoreServer;

    @FieldInfo(description = "flexicoreServerId",displayName = "flexicore server id")

    private String flexicoreServerId;


    public String getBasePathLike() {
        return basePathLike;
    }

    public FlexiCoreGatewayFiltering setBasePathLike(String basePathLike) {
        this.basePathLike = basePathLike;
        return this;
    }

    @JsonIgnore
    @Transient
    public FlexiCoreServer getFlexiCoreServer() {
        return flexiCoreServer;
    }

    public FlexiCoreGatewayFiltering setFlexiCoreServer(FlexiCoreServer flexiCoreServer) {
        this.flexiCoreServer = flexiCoreServer;
        return this;
    }

    public String getFlexicoreServerId() {
        return flexicoreServerId;
    }

    public FlexiCoreGatewayFiltering setFlexicoreServerId(String flexicoreServerId) {
        this.flexicoreServerId = flexicoreServerId;
        return this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();

    }
}
