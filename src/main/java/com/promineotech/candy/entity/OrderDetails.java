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
public class OrderDetails {
  
//  CREATE TABLE orderDetials(
//      order_id INT NOT NULL, 
//      product_id INT NOT NULL,
//      FOREIGN KEY(order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
//      FOREIGN KEY(product_id) REFERENCES products(product_id) ON DELETE CASCADE,
//      quantity int, 
//      paid_each decimal(5,2)

 private int orderId; 
 
 private int productId; 
 
 private int quantity; 
 
 private BigDecimal paidEach; 
  
  
}
