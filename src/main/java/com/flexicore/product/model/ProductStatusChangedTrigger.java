package com.flexicore.product.model;

import com.flexicore.rules.model.ScenarioTrigger;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;

@Entity
public class ProductStatusChangedTrigger extends ScenarioTrigger {

    public ProductStatusChangedTrigger() {
    }

    public ProductStatusChangedTrigger(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }
}
