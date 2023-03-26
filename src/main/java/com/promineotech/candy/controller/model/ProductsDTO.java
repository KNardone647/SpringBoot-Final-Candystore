package com.promineotech.candy.controller.model;

import java.math.BigDecimal;

public class ProductsDTO {

  

  private int productId;
  
  private String productName;
  
  private BigDecimal cost;
  
  private Integer inventory; 
  
  private String commonAllergiens; 
  
  private String ingredients; 
  
  private String brand;
  
  private String typeProduct;
  


  public int getProductId() {
    return productId;
  }



  public String getProductName() {
    return productName;
  }



  public BigDecimal getCost() {
    return cost;
  }



  public Integer getInventory() {
    return inventory;
  }



  public String getCommonAllergiens() {
    return commonAllergiens;
  }



  public String getIngredients() {
    return ingredients;
  }



  public String getBrand() {
    return brand;
  }



  public String getTypeProduct() {
    return typeProduct;
  }
  
}
