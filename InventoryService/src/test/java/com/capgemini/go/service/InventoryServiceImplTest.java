package com.capgemini.go.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.go.dto.InventoryDto;
import com.capgemini.go.dto.InventoryId;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryServiceImplTest {

	@Autowired
	InventoryService inventoryService;
	
	@Test
	void TestAddProductsToInventory() {
		InventoryId inventoryId = new InventoryId("P10004","R10002");
		InventoryDto inventoryDto = new InventoryDto(inventoryId, 656);
		inventoryService.addProductsToInventory(inventoryDto);
		assertThat(inventoryService.viewInventory()).isNotNull();
	}
	
	@Test
	void TestViewInventory() {
		assertThat(inventoryService.viewInventory()).isNotEmpty();
	}
	
	@Test
	void TestViewInventoryByProductId() {
		InventoryId inventoryId = new InventoryId("P10004","R10002");
		assertThat(inventoryService.viewInventoryByProductId(inventoryId.productId)).isNotNull();
	}
	
	@Test
	void TestViewInventoryByRetailerId() {
		InventoryId inventoryId = new InventoryId("P10004","R10002");
		assertThat(inventoryService.viewInventoryByRetailerId(inventoryId.retailerId)).isNotNull();
	}
	
	@Test
	void TestUpdateInventory() {
		InventoryId inventoryId = new InventoryId("P10004","R10002");
		InventoryDto inventoryDto = new InventoryDto(inventoryId, 700);
		assertThat(inventoryService.updateInventory(inventoryDto)).isNotNull();
	}
}
