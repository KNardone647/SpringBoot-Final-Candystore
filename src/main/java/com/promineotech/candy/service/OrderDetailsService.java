package com.promineotech.candy.service;

import java.util.List;
import com.promineotech.candy.entity.OrderDetails;

public interface OrderDetailsService {

  List<OrderDetails> fetchOrderDetials(int productId);

}
