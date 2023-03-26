package com.promineotech.candy.service;

import java.util.List;
import com.promineotech.candy.entity.OrderRequest;
import com.promineotech.candy.entity.Orders;

public interface OrderService {

  //commenting out all createOrders because I have it working in products 
//  Orders createOrder(OrderRequest orderRequest);

  List<Orders> fetchOrders();

}
