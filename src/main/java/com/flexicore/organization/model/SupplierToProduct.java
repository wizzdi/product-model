package com.flexicore.organization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.TimedLink;
import com.flexicore.product.model.Product;
import com.flexicore.security.SecurityContext;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SupplierToProduct extends Baseclass {

	@ManyToOne(targetEntity = Supplier.class)
	private Supplier supplier;
	@ManyToOne(targetEntity = Product.class)
	private Product product;
	private double price;


	public SupplierToProduct() {
	}

	public SupplierToProduct(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@ManyToOne(targetEntity = Supplier.class)
	public Supplier getSupplier() {
		return supplier;
	}

	public <T extends SupplierToProduct> T setSupplier(Supplier supplier) {
		this.supplier = supplier;
		return (T) this;
	}

	@ManyToOne(targetEntity = Product.class)
	public Product getProduct() {
		return product;
	}

	public <T extends SupplierToProduct> T setProduct(Product product) {
		this.product = product;
		return (T) this;
	}

	public <T extends SupplierToProduct> T setPrice(double price) {
		this.price = price;
		return (T) this;
	}

	public double getPrice() {
		return price;
	}

}
