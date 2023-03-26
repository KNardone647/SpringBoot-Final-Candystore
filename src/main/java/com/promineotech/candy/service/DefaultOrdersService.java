package com.promineotech.candy.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.candy.dao.OrdersDao;
import com.promineotech.candy.entity.Customers;
import com.promineotech.candy.entity.OrderRequest;
import com.promineotech.candy.entity.Orders;

@Service
public class DefaultOrdersService implements OrderService {

  @Autowired
  private OrdersDao ordersDao;

  @Override
  public List<Orders> fetchOrders() {
    return ordersDao.fetchOrders();
  } 
  
//  @Transactional
//  @Override
//  public Orders createOrder(OrderRequest orderRequest) {
//    Customers customers = getCustomer(orderRequest);
////    String size = getSize(orderRequest);
//    // I don't know how to get size and date in here 
//    
//    
//    return OrdersDao.saveOrder(customers);
//  }
  
  
// I have no idea what to do here 
//  private String getSize(OrderRequest orderRequest) {
//    return OrdersDao.fetchSize(OrderRequest.getSize());
//  }



//  protected Customers getCustomer(OrderRequest orderRequest) {
//    return ordersDao.fetchCustomers(orderRequest.getCustomers())
//        .orElseThrow(() -> new NoSuchElementException("Customer with ID=" 
//    + orderRequest.getCustomers() + "was not found"));
//  }

}
