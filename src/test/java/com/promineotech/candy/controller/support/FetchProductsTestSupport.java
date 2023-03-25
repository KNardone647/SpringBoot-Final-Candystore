package com.promineotech.candy.controller.support;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import com.promineotech.candy.entity.Products;

public class FetchProductsTestSupport extends BaseTest {

  

  protected List<Products> buildExpected() {
   List<Products> list = new LinkedList<>();
   
   // @formatter:off
   list.add(Products.builder()
          .productName("Coke")
          .cost(new BigDecimal("1.50"))
          .inventory(15)
          .commonAllergiens("none")
          .ingredients("water, carbonation, syrup")
          .brand("Coca Cola")
          .typeProduct("Soda")
          .build());
   
    list.add(Products.builder()
       .productName("Sprite")
       .cost(new BigDecimal("2.50"))
       .inventory(11)
       .commonAllergiens("none")
       .ingredients("water, carbonation, syrup")
       .brand("Coca Cola")
       .typeProduct("Soda")
       .build());

    // @formatter:on
   
   return null; 
  }
}

//INSERT INTO products (product_id , product_name, cost, inventory, common_allergiens, ingredients, brand, type_product) 
//VALUES(2, 'Sprite', 2.50, 11, 'none', 'water, carbonation, syrup', 'Coca Cola', 'Soda');
//INSERT INTO products (product_id , product_name, cost, inventory, common_allergiens, ingredients, brand, type_product) 
//VALUES(1, 'Coke', 1.50, 15, 'none', 'water, carbonation, syrup', 'Coca Cola', 'Soda');