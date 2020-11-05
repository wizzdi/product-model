package com.flexicore.product.interfaces;


public interface IEvent {

    default String getBaseclassPermissionId(){
        return null;
    }

    default String getEventType(){
        return getClass().getCanonicalName();
    }
}
