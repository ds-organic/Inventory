package com.organic.inventory.svc;

import java.util.List;

import com.organic.inventory.entity.Product;
import com.organic.inventory.entity.Products;
import com.organic.inventory.entity.UpdateProductRequest;

public interface InventoryService {

	public Products readXmlFile(String filePath);

	public void loadDataIntoEs(Products products);

	public Product getProductByProductId(String productId);

	public List<Product> getListOfProducts();

	public void updateProductByProductId(UpdateProductRequest updateProductRequest);

}
