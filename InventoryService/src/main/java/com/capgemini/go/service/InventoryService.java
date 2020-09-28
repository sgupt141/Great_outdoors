package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.dto.InventoryDto;

public interface InventoryService {
	
	public InventoryDto addProductsToInventory(InventoryDto inventoryDto); 
	public List<InventoryDto> viewInventory();
	public List<InventoryDto> viewInventoryByProductId(String prouductId);
	public List<InventoryDto> viewInventoryByRetailerId(String retailerId);
	public InventoryDto updateInventory(InventoryDto inventoryDto);
	//public boolean deleteProductByProductIdAndRetailerId(String productId, String retailerId);

}
