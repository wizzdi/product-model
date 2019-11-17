package com.flexicore.product.containers.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.dynamic.ExecutionParametersHolder;
import com.flexicore.product.model.Equipment;
import com.flexicore.product.model.Product;
import com.flexicore.product.model.ProductStatus;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class UpdateProductStatus extends ExecutionParametersHolder {

    @IdRefFieldInfo(refType = Equipment.class,list = false,mandatory = true)
    private String equipmentId;
    @JsonIgnore
    @Transient
    private Equipment equipment;
    @IdRefFieldInfo(refType = ProductStatus.class,list = false,mandatory = true)
    private String statusId;
    @JsonIgnore
    @Transient
    private ProductStatus productStatus;

    public String getEquipmentId() {
        return equipmentId;
    }

    public UpdateProductStatus setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
        return this;
    }
    @JsonIgnore
    @Transient
    public Equipment getEquipment() {
        return equipment;
    }

    public UpdateProductStatus setEquipment(Equipment equipment) {
        this.equipment = equipment;
        return this;
    }

    public String getStatusId() {
        return statusId;
    }

    public UpdateProductStatus setStatusId(String statusId) {
        this.statusId = statusId;
        return this;
    }
    @JsonIgnore
    @Transient
    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public UpdateProductStatus setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
        return this;
    }
}
