package com.promineotech.candy.service;

import java.math.BigDecimal;
import java.util.List;
import com.promineotech.candy.entity.Products;

public interface ProductsService {

  //for our get operation
  public List<Products> fetchProducts();

  //for our post/create operation
  public Products createProducts(String productName, BigDecimal cost, Integer inventory,
      String commonAllergiens, String ingredients, String brand, String typeProduct);

  
  // for put/update operation
  public Products updateProducts(int productId, String productName, BigDecimal cost, Integer inventory,
      String commonAllergiens, String ingredients, String brand, String typeProduct);

  // for delete operation
  public void deleteProducts(int productId);
}
