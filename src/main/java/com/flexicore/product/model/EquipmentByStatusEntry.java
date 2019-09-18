package com.flexicore.product.model;

import com.flexicore.model.Baseclass;
import org.bson.codecs.pojo.annotations.BsonId;

public class EquipmentByStatusEntry {

    @BsonId
    private String id;
    private String productStatus;
    private String productTypeId;
    private String equipmentByStatusEventId;
    private String name;
    private long total;

    public EquipmentByStatusEntry() {
        this.id= Baseclass.getBase64ID();
    }




    public String getId() {
        return id;
    }

    public EquipmentByStatusEntry setId(String id) {
        this.id = id;
        return this;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public EquipmentByStatusEntry setProductStatus(String productStatus) {
        this.productStatus = productStatus;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public EquipmentByStatusEntry setTotal(long total) {
        this.total = total;
        return this;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public <T extends EquipmentByStatusEntry> T setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
        return (T) this;
    }

    public String getName() {
        return name;
    }

    public <T extends EquipmentByStatusEntry> T setName(String name) {
        this.name = name;
        return (T) this;
    }

    public String getEquipmentByStatusEventId() {
        return equipmentByStatusEventId;
    }

    public <T extends EquipmentByStatusEntry> T setEquipmentByStatusEventId(String equipmentByStatusEventId) {
        this.equipmentByStatusEventId = equipmentByStatusEventId;
        return (T) this;
    }
}
