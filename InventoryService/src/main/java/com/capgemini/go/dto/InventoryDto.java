package com.capgemini.go.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory_table")
public class InventoryDto implements Serializable{
	
	@EmbeddedId
	private InventoryId inventoryId;

	@Column(name="units")
	private int units;

	public InventoryId getProductDto() {
		return inventoryId;
	}

	public void setProductDto(InventoryId productDto) {
		this.inventoryId = productDto;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public InventoryDto(InventoryId inventoryId, int units) {
		super();
		this.inventoryId = inventoryId;
		this.units = units;
	}

	public InventoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InventoryDto [productDto=" + inventoryId + ", units=" + units + "]";
	}


	
}
