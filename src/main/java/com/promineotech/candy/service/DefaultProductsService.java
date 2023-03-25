package com.promineotech.candy.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.candy.dao.ProductsDao;
import com.promineotech.candy.entity.Products;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultProductsService implements ProductsService {

  
 @Autowired
  private ProductsDao productsDao;
  
  @Override
  public List<Products> fetchProducts() {
    log.info(" fetchproducts was called");
    return productsDao.fetchProducts();
  }
  
  public Products createProducts(String productName, BigDecimal cost, Integer inventory,
      String commonAllergiens, String ingredients, String brand, String typeProduct) {
    return productsDao.createProducts(productName, cost, inventory,
        commonAllergiens, ingredients, brand, typeProduct);
    
  }
  

}
