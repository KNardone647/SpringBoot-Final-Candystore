package com.promineotech.candy.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.candy.controller.model.ProductsDTO;
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
  
  //create crud operation passing DTO with getters 
  
  @Override
  public Products createProducts(@Valid ProductsDTO productsDTO) {
     return productsService.createProducts(productsDTO.getProductName(), 
         productsDTO.getCost(), productsDTO.getInventory(), productsDTO.getCommonAllergiens(),
         productsDTO.getIngredients(), productsDTO.getBrand(), productsDTO.getTypeProduct());
  };
  
}
