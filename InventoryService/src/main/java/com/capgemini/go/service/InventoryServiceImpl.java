package com.capgemini.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.dao.InventoryDao;
import com.capgemini.go.dto.InventoryDto;
import com.capgemini.go.dto.InventoryId;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private InventoryDao repository;
	
	InventoryId productDto=new InventoryId();
	@Override
	public InventoryDto addProductsToInventory(InventoryDto inventoryDto) {
		
		return repository.save(inventoryDto);
	}

	@Override
	public List<InventoryDto> viewInventory() {
		return (List<InventoryDto>) repository.findAll();
	}
	
	@Override
	public List<InventoryDto> viewInventoryByProductId(String productId) {
		
		return repository.findAllByInventoryIdProductId(productId);
	}

	@Override
	public List<InventoryDto> viewInventoryByRetailerId(String retailerId) {
		return repository.findAllByInventoryIdRetailerId(retailerId);
	}
	

	@Override
	public InventoryDto updateInventory(InventoryDto inventoryDto) {
		return repository.save(inventoryDto);
	}

//	@Override
//	public boolean deleteProductByProductIdAndRetailerId(String productId, String retailerId) {
//		repository.deleteByInventoryIdProductIdRetailerId(productId, retailerId);
//		return true;
//	}


}
