package com.capgemini.go.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.go.dto.InventoryDto;
import com.capgemini.go.dto.InventoryId;


@Repository
public interface InventoryDao extends CrudRepository<InventoryDto,InventoryId>{
	public List<InventoryDto> findAllByInventoryIdProductId(String productId);
	public List<InventoryDto> findAllByInventoryIdRetailerId(String retailerId);
	
//	@Modifying
//	@Query(value = "delete from inventory_table where product_id=retailer_id")
//	public boolean deleteByInventoryIdProductIdRetailerId(String productId, String retailerId);
	
}
