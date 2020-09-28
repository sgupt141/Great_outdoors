package com.capgemini.go.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryId implements Serializable{
	
	@Column(name="product_id")
	public String productId;
	
	@Column(name="retailer_id")
	public String retailerId;

	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}

	
	public InventoryId(String productId, String retailerId) {
		super();
		this.productId = productId;
		this.retailerId = retailerId;
	}
	
	
	public InventoryId() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "InventoryId [productId=" + productId + ", retailerId=" + retailerId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		InventoryId invent = (InventoryId)obj;
		return productId.equals(invent.productId)&&retailerId.equals(invent.retailerId);
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(productId, retailerId);
	}
	
	

}
