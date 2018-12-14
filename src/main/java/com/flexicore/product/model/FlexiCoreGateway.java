package com.flexicore.product.model;

import javax.persistence.Entity;

@Entity
public class FlexiCoreGateway extends Gateway {
    private static FlexiCoreGateway s_Singleton=new FlexiCoreGateway();
    public  static FlexiCoreGateway s() {return s_Singleton;}

   private String communicationWebSocketUrl;
    private String baseApiUrl;


    public String getCommunicationWebSocketUrl() {
        return communicationWebSocketUrl;
    }

    public FlexiCoreGateway setCommunicationWebSocketUrl(String communicationWebSocketUrl) {
        this.communicationWebSocketUrl = communicationWebSocketUrl;
        return this;
    }

    public String getBaseApiUrl() {
        return baseApiUrl;
    }

    public FlexiCoreGateway setBaseApiUrl(String baseApiUrl) {
        this.baseApiUrl = baseApiUrl;
        return this;
    }


}
