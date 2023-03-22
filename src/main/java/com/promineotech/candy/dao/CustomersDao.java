package com.promineotech.candy.dao;

import java.util.List;
import com.promineotech.candy.entity.Customers;

public interface CustomersDao {

  List<Customers> fetchCustomers(String firstName, String lastName);

}
