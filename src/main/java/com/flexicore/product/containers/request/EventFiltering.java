package com.flexicore.product.containers.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Clazz;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.User;
import com.flexicore.product.model.Event;
import com.flexicore.product.model.LocationArea;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class EventFiltering extends FilteringInformationHolder {


    @FieldInfo(displayName = "Search Readable Text")
    private String humanReadableTextLike;

    private String eventType;
    @FieldInfo(displayName = "Event Sub Type")
    private String eventSubType;
    @OneToMany(targetEntity = BaseclassIdRef.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "Baseclass ids ",description = "Baseclass ids",refType = Baseclass.class)
    private Set<BaseclassIdRef> baseclassIds=new HashSet<>();
    @JsonIgnore
    @Transient
    private List<Baseclass> baseclass;
    private String clazzName;
    @JsonIgnore
    @Transient
    private Clazz clazz;

    @FieldInfo(displayName = "Location")
    @OneToOne(mappedBy = "equipmentFiltering",targetEntity = LocationArea.class)
    private LocationArea locationArea;
    @FieldInfo(displayName = "Source name")
    private String baseclassNameLike;
    @FieldInfo(displayName = "acknowledged")
    private Boolean acked;
    @OneToMany(targetEntity = AckedUserIdRef.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "acked user ids ",description = "acked user ids ",refType = AckedUserIdRef.class)
    private Set<AckedUserIdRef> ackedUsersIds =new HashSet<>();
    @JsonIgnore
    @Transient
    private List<User> ackedUsers;

    @OneToMany(targetEntity = TargetBaseclassIdRef.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "target baseclass ids ",description = "target baseclass ids",refType = TargetBaseclassIdRef.class)
    private Set<TargetBaseclassIdRef> targetBaseclassIds=new HashSet<>();
    @JsonIgnore
    @Transient
    private List<Baseclass> targetBaseclass;

    @FieldInfo
    private Boolean falseAlarm;

    public EventFiltering(EventFiltering other) {
        this.humanReadableTextLike = other.humanReadableTextLike;
        this.eventType = other.eventType;
        this.eventSubType = other.eventSubType;
        this.baseclassIds = other.baseclassIds;
        this.baseclass = other.baseclass;
        this.clazzName = other.clazzName;
        this.clazz = other.clazz;
        this.locationArea = other.locationArea;
        this.baseclassNameLike = other.baseclassNameLike;
        this.acked=other.acked;
        this.ackedUsers=other.ackedUsers;
        this.ackedUsersIds=other.ackedUsersIds;
        this.targetBaseclass=other.targetBaseclass;
        this.targetBaseclassIds=other.targetBaseclassIds;
        this.falseAlarm=other.falseAlarm;
    }

    public EventFiltering() {
        eventType= Event.class.getCanonicalName();
    }

    public String getHumanReadableTextLike() {
        return humanReadableTextLike;
    }

    public <T extends EventFiltering> T setHumanReadableTextLike(String humanReadableTextLike) {
        this.humanReadableTextLike = humanReadableTextLike;
        return (T) this;
    }

    public String getEventType() {
        return eventType;
    }

    public <T extends EventFiltering> T setEventType(String eventType) {
        this.eventType = eventType;
        return (T) this;
    }

    public String getEventSubType() {
        return eventSubType;
    }

    public <T extends EventFiltering> T setEventSubType(String eventSubType) {
        this.eventSubType = eventSubType;
        return (T) this;
    }
    @OneToMany(targetEntity = BaseclassIdRef.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<BaseclassIdRef> getBaseclassIds() {
        return baseclassIds;
    }

    public <T extends EventFiltering> T setBaseclassIds(Set<BaseclassIdRef> baseclassIds) {
        this.baseclassIds = baseclassIds;
        return (T) this;
    }

    @Transient
    @JsonIgnore
    public List<Baseclass> getBaseclass() {
        return baseclass;
    }

    public <T extends EventFiltering> T setBaseclass(List<Baseclass> baseclass) {
        this.baseclass = baseclass;
        return (T) this;
    }

    public String getClazzName() {
        return clazzName;
    }

    public <T extends EventFiltering> T setClazzName(String clazzName) {
        this.clazzName = clazzName;
        return (T) this;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public <T extends EventFiltering> T setClazz(Clazz clazz) {
        this.clazz = clazz;
        return (T) this;
    }

    @OneToOne(mappedBy = "equipmentFiltering",targetEntity = LocationArea.class)
    public LocationArea getLocationArea() {
        return locationArea;
    }

    public <T extends EventFiltering> T setLocationArea(LocationArea locationArea) {
        this.locationArea = locationArea;
        return (T) this;
    }

    public String getBaseclassNameLike() {
        return baseclassNameLike;
    }

    public <T extends EventFiltering> T setBaseclassNameLike(String baseclassNameLike) {
        this.baseclassNameLike = baseclassNameLike;
        return (T) this;
    }

    public Boolean getAcked() {
        return acked;
    }

    public <T extends EventFiltering> T setAcked(Boolean acked) {
        this.acked = acked;
        return (T) this;
    }

    @OneToMany(targetEntity = AckedUserIdRef.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<AckedUserIdRef> getAckedUsersIds() {
        return ackedUsersIds;
    }

    public <T extends EventFiltering> T setAckedUsersIds(Set<AckedUserIdRef> ackedUsersIds) {
        this.ackedUsersIds = ackedUsersIds;
        return (T) this;
    }

    @Transient
    @JsonIgnore
    public List<User> getAckedUsers() {
        return ackedUsers;
    }

    public <T extends EventFiltering> T setAckedUsers(List<User> ackedUsers) {
        this.ackedUsers = ackedUsers;
        return (T) this;
    }

    @OneToMany(targetEntity = TargetBaseclassIdRef.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "filteringInformationHolder")
    public Set<TargetBaseclassIdRef> getTargetBaseclassIds() {
        return targetBaseclassIds;
    }

    public <T extends EventFiltering> T setTargetBaseclassIds(Set<TargetBaseclassIdRef> targetBaseclassIds) {
        this.targetBaseclassIds = targetBaseclassIds;
        return (T) this;
    }

    @JsonIgnore
    @Transient
    public List<Baseclass> getTargetBaseclass() {
        return targetBaseclass;
    }

    public <T extends EventFiltering> T setTargetBaseclass(List<Baseclass> targetBaseclass) {
        this.targetBaseclass = targetBaseclass;
        return (T) this;
    }

    public Boolean getFalseAlarm() {
        return falseAlarm;
    }

    public <T extends EventFiltering> T setFalseAlarm(Boolean falseAlarm) {
        this.falseAlarm = falseAlarm;
        return (T) this;
    }
}
