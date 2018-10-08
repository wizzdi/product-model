package com.flexicore.product.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity
public class Gateway extends Equipment {
    static Gateway s_Singleton = new Gateway();

    public static Gateway s() {
        return s_Singleton;
    }

    private LocalDateTime lastSucessfulConnction;

    public LocalDateTime getLastSucessfulConnction() {
        return lastSucessfulConnction;
    }

    public Gateway setLastSucessfulConnction(LocalDateTime lastSucessfulConnction) {
        this.lastSucessfulConnction = lastSucessfulConnction;
        return this;
    }


}
