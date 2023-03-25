package com.promineotech.candy.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.candy.entity.Products;
import com.promineotech.candy.service.ProductsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DefaultProductsController implements ProductsController {

  
  // passing to service layer 
  
  @Autowired
  private ProductsService productsService;
  
  @Override
  public List<Products> fetchProducts() {
    return productsService.fetchProducts();
  }
  
  @Override
  public Products createProducts(String productName,
      BigDecimal cost, Integer inventory, String commonAllergiens, String ingredients,
      String brand, String typeProduct) {
     return productsService.createProducts(productName, cost, inventory, commonAllergiens,
         ingredients, brand, typeProduct);
  };
  
}
