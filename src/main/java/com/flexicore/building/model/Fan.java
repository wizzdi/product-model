package com.flexicore.building.model;

import com.flexicore.product.model.Equipment;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;

@Entity
public class Fan extends Equipment {

	public Fan() {
		super();
	}

	public Fan(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}
}
