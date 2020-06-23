package com.flexicore.product.model;

import com.flexicore.iot.model.FlexiCoreServer;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class FlexiCoreGateway extends Gateway {


    public FlexiCoreGateway() {
    }

    public FlexiCoreGateway(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @OneToOne(targetEntity = FlexiCoreServer.class)
    private FlexiCoreServer flexiCoreServer;

    @OneToOne(targetEntity = FlexiCoreServer.class)
    public FlexiCoreServer getFlexiCoreServer() {
        return flexiCoreServer;
    }

    public FlexiCoreGateway setFlexiCoreServer(FlexiCoreServer flexiCoreServer) {
        this.flexiCoreServer = flexiCoreServer;
        return this;
    }
}
