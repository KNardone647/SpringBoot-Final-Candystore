package com.promineotech.candy.dao;

import java.math.BigDecimal;
import java.util.List;
import com.promineotech.candy.entity.Products;

public interface ProductsDao {

  
  // creating the method for getting the products 
  
  List<Products> fetchProducts();

  //creating the POST method for the products
  Products createProducts(String productName, BigDecimal cost, Integer inventory,
      String commonAllergiens, String ingredients, String brand, String typeProduct);

}
