package com.organic.inventory.svc;

import com.organic.inventory.entity.Product;
import com.organic.inventory.entity.Products;

public interface InventoryService {

	public Products readXmlFile(String filePath);

	public void loadDataIntoEs(Products products);

	public Product getProductByProductId(String productId);

}
