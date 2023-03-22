package com.promineotech.candy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.candy.dao.CustomersDao;
import com.promineotech.candy.entity.Customers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultCustomersService implements CustomersService {

  
  // creating class and sending everything to Dao layer
  
  @Autowired
  private CustomersDao customersDao; 
  
 
  
  @Override
  public List<Customers> fetchCustomers(String firstName, String lastName) {
    log.info("the fetchcustomers services was called with firstname and lastname", firstName, lastName);
    
    return customersDao.fetchCustomers(firstName, lastName);
  }

}
