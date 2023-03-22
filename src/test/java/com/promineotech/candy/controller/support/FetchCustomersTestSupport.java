package com.promineotech.candy.controller.support;

import java.util.LinkedList;
import java.util.List;
import com.promineotech.candy.entity.Customers;

public class FetchCustomersTestSupport extends BaseTest {
  
  
  protected List<Customers> buildExpected() {
   List<Customers> list = new LinkedList<>();
   
   //below using builder to add to the linkedlist 
   
   // @formatter:off
   list.add(Customers.builder()
       .firstName("Melissa")
       .lastName("Jones")
       .phone("755.223.5969")
       .build());
   
   list.add(Customers.builder()
       .firstName("Esmery")
       .lastName("Ramirez")
       .phone("755.223.5769")
       .build());
   // @formatter:on
   
   return list; 
  }


}
