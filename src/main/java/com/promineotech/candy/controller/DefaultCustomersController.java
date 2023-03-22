package com.promineotech.candy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.candy.entity.Customers;
import com.promineotech.candy.service.CustomersService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCustomersController implements CustomersController {

  // autowired tells spring that we want object to be injected with a managed bean
 @Autowired
 private CustomersService customersService;
  
  
  @Override
  // note I named this method wrong it should indicate only fetching one customer 
  //by first and last name 
  public List<Customers> fetchCustomers(String firstName, String lastName) {
    log.debug("firstName{}, lastName{}", firstName, lastName);
    return customersService.fetchCustomers(firstName, lastName); 
  }

}

