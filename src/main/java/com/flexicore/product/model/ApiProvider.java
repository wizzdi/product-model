package com.flexicore.product.model;

import com.flexicore.model.Baseclass;
import com.flexicore.organization.model.Manufacturer;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class ApiProvider extends Baseclass {
    static ApiProvider s_Singleton = new ApiProvider();

    public static ApiProvider s() {
        return s_Singleton;
    }

    private String url;
    private String username;
    private String password;

    public ApiProvider() {
    }

    public ApiProvider(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    public String getUrl() {
        return url;
    }

    public ApiProvider setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ApiProvider setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ApiProvider setPassword(String password) {
        this.password = password;
        return this;
    }
}
