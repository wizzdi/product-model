package com.flexicore.product.model;

import javax.persistence.Entity;

@Entity
public class FlexiCoreGateway extends Equipment {
    private static FlexiCoreGateway s_Singleton=new FlexiCoreGateway();
    public  static FlexiCoreGateway s() {return s_Singleton;}

   private String communicationWebSocketUrl;


    public String getCommunicationWebSocketUrl() {
        return communicationWebSocketUrl;
    }

    public FlexiCoreGateway setCommunicationWebSocketUrl(String communicationWebSocketUrl) {
        this.communicationWebSocketUrl = communicationWebSocketUrl;
        return this;
    }

}
