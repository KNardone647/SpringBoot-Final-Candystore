package com.promineotech.candy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.candy.entity.OrderRequest;
import com.promineotech.candy.entity.Orders;
import com.promineotech.candy.service.OrderService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultOrdersController implements OrdersController {
  
  
  @Autowired
 private OrderService orderService;

  @Override
  public List<Orders> fetchOrders() {
   return orderService.fetchOrders();
  }
  
  
  
//  @Override
//  public Orders createOrder(OrderRequest orderRequest) {
//    log.debug("Order={}", orderRequest);
//    return orderService.createOrder(orderRequest);
//  }
  
 
}
