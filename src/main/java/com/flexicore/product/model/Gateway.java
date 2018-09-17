package com.flexicore.product.model;

import javax.persistence.Entity;


@Entity
public class Gateway extends Equipment {
    static Gateway s_Singleton = new Gateway();

    public static Gateway s() {
        return s_Singleton;
    }


}
