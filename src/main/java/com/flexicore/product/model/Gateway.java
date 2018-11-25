package com.flexicore.product.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity
public class Gateway extends Equipment {
    static Gateway s_Singleton = new Gateway();

    public static Gateway s() {
        return s_Singleton;
    }

    private LocalDateTime lastSucessfulConnction;
    private String ip;
    private int port;
    private String encryptedUsername;
    private String encryptedPassword;

    public LocalDateTime getLastSucessfulConnction() {
        return lastSucessfulConnction;
    }

    public Gateway setLastSucessfulConnction(LocalDateTime lastSucessfulConnction) {
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

    public String getEncryptedUsername() {
        return encryptedUsername;
    }

    public Gateway setEncryptedUsername(String encryptedUsername) {
        this.encryptedUsername = encryptedUsername;
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
