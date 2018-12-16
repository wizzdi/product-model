package com.flexicore.product.model;

import com.flexicore.model.FlexiCoreServer;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class FlexiCoreGateway extends Gateway {
    private static FlexiCoreGateway s_Singleton=new FlexiCoreGateway();
    public  static FlexiCoreGateway s() {return s_Singleton;}


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
