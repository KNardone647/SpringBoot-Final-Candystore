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
  
  //method that gets connection for Products Table 
  protected String getBaseUriForProducts() {
    
    return String.format("http://localhost:%d/products", serverPort);
  }
  
  //method for new Products 
    protected String getBaseUriForNewProducts() {
    
    return String.format("http://localhost:%d/newproducts", serverPort);
  }
    
    //base URI method call for orders 
    protected String getBaseUriForOrders() {
      
      return String.format("http://localhost:%d/orders", serverPort);
    }
     
    

    
    //base URI method call for order detials 
    protected String getBaseUriForOrderDetials() {
      
      return String.format("http://localhost:%d/orderdetials", serverPort);
    }
     
}
