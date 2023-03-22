package com.promineotech.candy.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Products {
  


    private int productId;
    
    private String productName;
    
    private BigDecimal cost;
    
    private int inventory; 
    
    private String commonAllergiens; 
    
    private String ingredients; 
    
    private String brand;
    
    private String typeProduct;
    
   
    

    
  }


