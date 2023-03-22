package com.promineotech.candy.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import lombok.Getter;

public class BaseTest {

  //this is how we get the random port within the local machine environment 
  @LocalServerPort
  private int serverPort;
  
  //autowired connects to restTemplate, Getter uses lombok to create getters for us
  @Autowired
  @Getter
  private TestRestTemplate restTemplate; 
  
  //method that gets connection for Customers Table 
  protected String getBaseUriForCustomers() {
   
    return String.format("http://localhost:%d/customers", serverPort);
  }
}
