package com.promineotech.candy.controller.support;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
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
  
  protected void assertErrorMessageValid(Map<String, Object> error, 
      HttpStatus status) {
    //@formatter: off
    assertThat(error)
    .containsKey("message")
    .containsEntry("Status code", status.value())
    .containsEntry("uri", "/customers")
    .containsKey("timestamp")
    .containsEntry("reason", status.getReasonPhrase());
    //@formatter: on 
  }



}
