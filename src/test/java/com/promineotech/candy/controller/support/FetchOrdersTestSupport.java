package com.promineotech.candy.controller.support;

import static org.assertj.core.api.Assertions.assertThat;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import com.promineotech.candy.entity.Customers;
//import com.promineotech.candy.entity.Customers;
import com.promineotech.candy.entity.Orders;

import java.sql.Date;

public class FetchOrdersTestSupport extends BaseTest {

//  
//  protected List<Orders> buildExpected() {
//    List<Orders> list = new LinkedList<>();
    
    //below using builder to add to the linkedlist 
//    private Long orderId; 
//    
//    private Customers customers;
//    
//    private String size; 
//    
//    private Date orderDate; 
    
//    INSERT INTO orders (order_id , customer_id, size, order_date) VALUES(3, 4, 'large', '2023-01-04');
//    INSERT INTO orders (order_id , customer_id, size, order_date) VALUES(4, 3, 'large', '2023-02-08');
//    
//    // @formatter:off
//    list.add(Orders.builder()
//        .customerId(4)
//        .size("large")
//        .orderDate(2023-01-04)
//        .build());
//    
//    list.add(Orders.builder()
//        .firstName("Esmery")
//        .lastName("Ramirez")
//        .phone("755.223.5769")
//        .build());
//    // @formatter:on
//    
//    return list; 
//   }
//   
//   protected void assertErrorMessageValid(Map<String, Object> error, 
//       HttpStatus status) {
//     //@formatter: off
//     assertThat(error)
//     .containsKey("message")
//     .containsEntry("Status code", status.value())
//     .containsEntry("uri", "/customers")
//     .containsKey("timestamp")
//     .containsEntry("reason", status.getReasonPhrase());
//     //@formatter: on 
//   }


}
