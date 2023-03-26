package com.promineotech.candy.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.candy.controller.support.CreateOrderTestSupport;
import com.promineotech.candy.entity.Orders;
import org.springframework.http.HttpHeaders;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
  scripts = {"classpath:flyway/migrations/CandyStore1.sql", 
             "classpath:flyway/migrations/CandyStoreData.sql"}, 
      config = @SqlConfig(encoding = "utf-8"))
class CreateOrdersTest extends CreateOrderTestSupport{

  /*
   * 
   */
  
//  @Test
//  void testCreateOrderReturnsScucess201() {
//    
//    // Given: an order as JSON 
//   String body = createOrderBody();
//   String uri = getBaseUriForOrders();
//   
//   HttpHeaders headers = new HttpHeaders();
//   headers.setContentType(MediaType.APPLICATION_JSON);
//   
//   HttpEntity<String> bodyEntity = new HttpEntity<>(body);
//   
//   //When: the order is sent
//   ResponseEntity<Orders> response = getRestTemplate().exchange(uri, HttpMethod.POST,
//       bodyEntity, Orders.class);
//   
//   //Then: a 201 status is returned
//   
//   assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//   // And: the returned order is correct
//   
//   assertThat(response.getBody()).isNotNull();
//   
//   Orders orders = response.getBody();
//   assertThat(orders.getCustomers().getcustomerId()).isEqualTo(1);
//  }
//  
//  moved to support class 
//  protected String createOrderBody() {
//    //@formatter:off
//    return "{\n"
//        + "   \"size\":\"medium\",\n"
//        + "   \"order_date\":\"2022-12-31\"\n"
//        + "}";
//    //formatter:on
//  }

}
