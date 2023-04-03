package com.promineotech.candy.dao;

import java.util.List;
import com.promineotech.candy.entity.OrderDetails;


public interface OrderDetialsDao {

  List<OrderDetails> fetchOrderDetials(int productId);

}
