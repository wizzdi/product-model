package com.flexicore.product.interfaces;


public interface IEvent {

    default String getBaseclassPermissionId(){
        return null;
    }
}
