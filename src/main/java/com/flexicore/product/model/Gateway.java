package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import java.time.OffsetDateTime;


@Entity
public class Gateway extends Equipment {


    public Gateway() {
    }

    public Gateway(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    private OffsetDateTime lastSucessfulConnction;
    private String ip;
    private int port;
    private String username;
    @JsonIgnore
    private String encryptedPassword;

    public OffsetDateTime getLastSucessfulConnction() {
        return lastSucessfulConnction;
    }

    public Gateway setLastSucessfulConnction(OffsetDateTime lastSucessfulConnction) {
        this.lastSucessfulConnction = lastSucessfulConnction;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public Gateway setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public int getPort() {
        return port;
    }

    public Gateway setPort(int port) {
        this.port = port;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Gateway setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public Gateway setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
        return this;
    }


}
