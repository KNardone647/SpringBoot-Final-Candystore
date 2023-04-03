package com.promineotech.candy.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.candy.dao.CustomersDao;
import com.promineotech.candy.dao.OrderDetialsDao;
import com.promineotech.candy.entity.OrderDetails;

@Service
public class DefaultOrderDetialsService implements OrderDetailsService {

  @Autowired
  private OrderDetialsDao orderDetialsDao; 
  
  
  @Override
  public List<OrderDetails> fetchOrderDetials(int productId) {
    
    List<OrderDetails> orderDetials = orderDetialsDao.fetchOrderDetials(productId);
     if(orderDetials.isEmpty()) {
       String msg = String.format("No service line item was found with productId=%s", productId);
       throw new NoSuchElementException(msg);
     }
     return orderDetials; 
  }

}
