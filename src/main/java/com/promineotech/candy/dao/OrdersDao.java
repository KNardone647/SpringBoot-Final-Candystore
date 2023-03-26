package com.promineotech.candy.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.candy.entity.Customers;
import com.promineotech.candy.entity.OrderRequest;
import com.promineotech.candy.entity.Orders;

public interface OrdersDao {

// Optional<Customers> fetchCustomers(String customerId);
//
//static Orders saveOrder(Customers customers) {
//  // TODO Auto-generated method stub
//  return null;
//}

List<Orders> fetchOrders();

//static String fetchSize(String size) {
//  // TODO Auto-generated method stub
//  return null;
//}


}
