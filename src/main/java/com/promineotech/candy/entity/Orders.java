package com.promineotech.candy.entity;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
  
//  *** check on date is that the correct import? ***
//  order_id INT AUTO_INCREMENT NOT NULL, 
//  customer_id INT NOT NULL,
//  FOREIGN KEY(customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE,
//  size TEXT,
//  order_date DATE NOT NULL,
//  PRIMARY KEY(order_id)

  private int orderId; 
  
  private int customerId;
  
  private String size; 
  
  private Date orderDate; 
  
  
  
  
}
