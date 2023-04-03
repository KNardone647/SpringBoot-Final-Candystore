package com.promineotech.candy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.candy.entity.OrderDetails;
import com.promineotech.candy.service.CustomersService;
import com.promineotech.candy.service.OrderDetailsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultOrderDetialsController implements OrderDetialsController {
  
  
  @Autowired
  private OrderDetailsService orderDetialsService;

  @Override
  public List<OrderDetails> fetchOrderDetials(int productId) {
    return orderDetialsService.fetchOrderDetials(productId);
  }

}
