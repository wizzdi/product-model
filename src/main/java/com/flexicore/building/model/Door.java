package com.flexicore.building.model;

import com.flexicore.product.model.Equipment;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;

@Entity
public class Door extends Equipment {

	public Door() {
	}

	public Door(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}
}
