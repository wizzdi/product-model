package com.flexicore.iot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.product.model.Equipment;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ExternalServer extends Equipment {
    static ExternalServer s_Singleton = new ExternalServer();
    public static ExternalServer s() {
        return s_Singleton;
    }

    private String url;
    private long inspectIntervalMs;
    private long inspectAfterActivateIntervalMs;

    private LocalDateTime lastInspectAttempt;
    private LocalDateTime lastSuccessfulInspect;


    @JsonIgnore
    @OneToMany(targetEntity = ExternalServerUser.class,mappedBy = "externalServer")
    private List<ExternalServerUser> externalServerUserList=new ArrayList<>();


    public ExternalServer() {
    }

    public ExternalServer(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }


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

    public long getInspectIntervalMs() {
        return inspectIntervalMs;
    }

    public <T extends ExternalServer> T setInspectIntervalMs(long inspectIntervalMs) {
        this.inspectIntervalMs = inspectIntervalMs;
        return (T) this;
    }

    public LocalDateTime getLastInspectAttempt() {
        return lastInspectAttempt;
    }

    public <T extends ExternalServer> T setLastInspectAttempt(LocalDateTime lastInspectAttempt) {
        this.lastInspectAttempt = lastInspectAttempt;
        return (T) this;
    }

    public LocalDateTime getLastSuccessfulInspect() {
        return lastSuccessfulInspect;
    }

    public <T extends ExternalServer> T setLastSuccessfulInspect(LocalDateTime lastSuccessfulInspect) {
        this.lastSuccessfulInspect = lastSuccessfulInspect;
        return (T) this;
    }

    public long getInspectAfterActivateIntervalMs() {
        return inspectAfterActivateIntervalMs;
    }

    public <T extends ExternalServer> T setInspectAfterActivateIntervalMs(long inspectAfterActivateIntervalMs) {
        this.inspectAfterActivateIntervalMs = inspectAfterActivateIntervalMs;
        return (T) this;
    }
}
