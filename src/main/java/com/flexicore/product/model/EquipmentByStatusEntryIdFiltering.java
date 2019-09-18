package com.flexicore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//import io.swagger.annotations.ApiModelProperty;


@Entity
public class EquipmentByStatusEntryIdFiltering {

    @Id
    private String filterId;

    @FieldInfo(displayName = "string",description = "string filter",mandatory = true)
    private String id;
    @ManyToOne(targetEntity = FilteringInformationHolder.class)
    @JsonIgnore
    private FilteringInformationHolder filteringInformationHolder;

    public EquipmentByStatusEntryIdFiltering() {
    }

    //@ApiModelProperty("Id of the Baseclass")
    public String getId() {
        return id;
    }


    public EquipmentByStatusEntryIdFiltering setId(String id) {
        this.id = id;
        return this;
    }

    public EquipmentByStatusEntryIdFiltering(String id) {
        this.id = id;
    }

    @Id
    public String getFilterId() {
        return filterId;
    }

    public EquipmentByStatusEntryIdFiltering setFilterId(String filterId) {
        this.filterId = filterId;
        return this;
    }

    @ManyToOne(targetEntity = FilteringInformationHolder.class)
    @JsonIgnore
    public FilteringInformationHolder getFilteringInformationHolder() {
        return filteringInformationHolder;
    }

    public EquipmentByStatusEntryIdFiltering setFilteringInformationHolder(FilteringInformationHolder filteringInformationHolder) {
        this.filteringInformationHolder = filteringInformationHolder;
        return this;
    }

    public void prepareForSave(FilteringInformationHolder filteringInformationHolder) {
        filterId = Baseclass.getBase64ID();
        this.filteringInformationHolder = filteringInformationHolder;

    }
}
