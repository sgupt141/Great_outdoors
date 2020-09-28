package com.capgemini.go.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.dto.InventoryDto;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.service.InventoryService;

@RestController
@RequestMapping("/api")
public class InventoryController {

	@Autowired
	InventoryService service;
	
	@PostMapping("/addProductToInventory")
	public InventoryDto addProductToIventory(@RequestBody InventoryDto inventoryDto) {
		return service.addProductsToInventory(inventoryDto);
	}
	
	@GetMapping("/viewInventory")
	public List<InventoryDto> viewInventory(){
		return service.viewInventory();
	}
	@GetMapping("/viewInventoryByProductId/{product_id}")
	public List<InventoryDto> ViewProductByProductId(@PathVariable("product_id") String productId){
		try {
			return service.viewInventoryByProductId(productId);
		}
		catch(Exception e) {
			throw new ProductNotFoundException(e.getMessage());
		}
	}
	
	@GetMapping("/viewInventoryByRetailerId/{retailer_id}")
	public List<InventoryDto> ViewProductByRetailerId(@PathVariable("retailer_id") String retailerId){
		try{
			return service.viewInventoryByRetailerId(retailerId);
		}
		catch(Exception e) {
			throw new ProductNotFoundException(e.getMessage());
		}
		
	}
	
	@PutMapping("/updateInventory")
	public ResponseEntity<Object> updateInventory(@RequestBody InventoryDto inventoryDto) {
		try {
			service.updateInventory(inventoryDto);
			return new ResponseEntity<>("Updated Succesfully",HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ProductNotFoundException(e.getMessage());
		}
	}
	
//	@DeleteMapping("/deleteProductByProductIdAndRetailerId/{product_id}/{retailer_id}")
//	public boolean deleteProductByProductIdAndRetailerId(@PathVariable("product_id") String productId, @PathVariable("retailer_id") String retailerId) {
//		service.deleteProductByProductIdAndRetailerId(productId,retailerId);
//		return true;
//	}

}
