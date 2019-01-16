package com.flexicore.iot;

import com.flexicore.model.Baseclass;

import javax.persistence.Entity;

@Entity
public class ExternalServer extends Baseclass {
    static ExternalServer s_Singleton = new ExternalServer();
    public static ExternalServer s() {
        return s_Singleton;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public ExternalServer setUrl(String url) {
        this.url = url;
        return this;
    }
}
