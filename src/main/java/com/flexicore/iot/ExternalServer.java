package com.flexicore.iot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.product.model.Equipment;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ExternalServer extends Equipment {
    static ExternalServer s_Singleton = new ExternalServer();
    public static ExternalServer s() {
        return s_Singleton;
    }

    public ExternalServer() {
    }

    public ExternalServer(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    private String url;
    @JsonIgnore
    @OneToMany(targetEntity = ExternalServerUser.class,mappedBy = "externalServer")
    private List<ExternalServerUser> externalServerUserList=new ArrayList<>();

    public String getUrl() {
        return url;
    }

    public ExternalServer setUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonIgnore
    @OneToMany(targetEntity = ExternalServerUser.class,mappedBy = "externalServer")
    public List<ExternalServerUser> getExternalServerUserList() {
        return externalServerUserList;
    }

    public <T extends ExternalServer> T setExternalServerUserList(List<ExternalServerUser> externalServerUserList) {
        this.externalServerUserList = externalServerUserList;
        return (T) this;
    }
}
