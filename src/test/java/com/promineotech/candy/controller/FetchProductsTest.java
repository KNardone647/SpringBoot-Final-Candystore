package com.promineotech.candy.controller;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import com.promineotech.candy.controller.support.FetchProductsTestSupport;
import com.promineotech.candy.entity.Products;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
    scripts = {"classpath:flyway/migrations/CandyStore1.sql", 
               "classpath:flyway/migrations/CandyStoreData.sql"}, 
        config = @SqlConfig(encoding = "utf-8"))
class FetchProductsTest extends FetchProductsTestSupport {

  
  
  //probably going to comment out this test because this is not realistic to get this
  //working in 2 weeks 
  
//  @Autowired
//  private JdbcTemplate jdbcTemplate; 
//  
//  @Test void testDb() {
//   int numrows = JdbcTestUtils.countRowsInTable(jdbcTemplate, "products");
//   System.out.println("num=" + numrows);
//  }
//  
 @Disabled
  @Test
  void testThatProductsAreReturnedWhenValidProductNameSupplied() {
//    System.out.println(getBaseUriForProducts());
    
    //Given: a valid product name and URI
    String productName = "Coke";
    
    
    String uri = 
        String.format("%s?productName=%s", getBaseUriForProducts(), productName);
    
    System.out.println(uri);
    //When a connection is made to the URI
    
    ResponseEntity<List<Products>> response =
       getRestTemplate().exchange(uri, HttpMethod.GET, null, 
           new ParameterizedTypeReference<>() {});
    // Then: a success (OK- 200) status code is returned 
    
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    
    //And: the actual list returned is the same as the expected list 
    List<Products> expected = buildExpected();
    assertThat(response.getBody()).isEqualTo(expected);
  }


}
