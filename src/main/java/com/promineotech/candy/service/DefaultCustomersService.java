package com.promineotech.candy.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.candy.dao.CustomersDao;
import com.promineotech.candy.entity.Customers;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultCustomersService implements CustomersService {

  
  // creating class and sending everything to Dao layer
  
  @Autowired
  private CustomersDao customersDao; 
  
 
  
  @Override
  @Transactional(readOnly = true)
  public List<Customers> fetchCustomers(String firstName, String lastName) {
    log.info("Find the customer");
    List<Customers> customers = customersDao.fetchCustomers(firstName, lastName);
    
    if(customers.isEmpty()) {
      String msg = String.format("No customers found with first and last name", firstName, lastName);
      throw new NoSuchElementException(msg);
    }
    
    return customers;
  }

}
