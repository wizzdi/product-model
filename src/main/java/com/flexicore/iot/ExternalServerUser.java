package com.flexicore.iot;

import com.flexicore.model.Baseclass;

import javax.persistence.Entity;

@Entity
public class ExternalServerUser extends Baseclass {
    static ExternalServerUser s_Singleton = new ExternalServerUser();

    public static ExternalServerUser s() {
        return s_Singleton;
    }

    private String username;
    private String password;

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
}
