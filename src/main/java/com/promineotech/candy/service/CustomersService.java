package com.promineotech.candy.service;

import java.util.List;
import com.promineotech.candy.entity.Customers;

public interface CustomersService {

  // this is by firstName and lastName
  List<Customers> fetchCustomers(String firstName, String lastName);

}
