package com.flexicore.iot;

import com.flexicore.model.Baseclass;
import com.flexicore.product.model.Equipment;

import javax.persistence.Entity;

@Entity
public class ExternalServer extends Equipment {
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
