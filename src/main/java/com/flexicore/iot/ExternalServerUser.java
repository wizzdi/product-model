package com.flexicore.iot;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ExternalServerUser extends Baseclass {
    public ExternalServerUser() {
    }

    public ExternalServerUser(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    private String username;
    private String password;
    @ManyToOne(targetEntity = ExternalServer.class)
    private ExternalServer externalServer;

    public String getUsername() {
        return username;
    }

    public ExternalServerUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ExternalServerUser setPassword(String password) {
        this.password = password;
        return this;
    }

    @ManyToOne(targetEntity = ExternalServer.class)

    public ExternalServer getExternalServer() {
        return externalServer;
    }

    public <T extends ExternalServerUser> T setExternalServer(ExternalServer externalServer) {
        this.externalServer = externalServer;
        return (T) this;
    }
}
