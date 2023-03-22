package com.promineotech.candy.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import com.promineotech.candy.controller.support.FetchCustomersTestSupport;
import com.promineotech.candy.entity.Customers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
  scripts = {"CandyStore1.sql", 
             "CandyStoreData.sql"}, 
      config = @SqlConfig(encoding = "utf-8"))
class FetchCustomersTest extends FetchCustomersTestSupport{
 
 
  @Test
void testThatCustomerIsReturnedWhenValidFirstandLastNameSupplied() {
   //Given: a valid firstName and lastName
     String firstName = "Melissa";
     String lastName = "Jones";
     
     String uri =String.format("%s?firstName=%s&lastName=%s", getBaseUriForCustomers(), firstName, lastName);
     
     
    
     
    //When: a connection is made to the URI
     //this expects list of customers back 
     
     ResponseEntity<List<Customers>> response =
         getRestTemplate().exchange(uri,HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    
    //Then: a success (OK - 200) Status Code is returned 
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //And: the actual list is the same as the expected list 
    List<Customers> actual = response.getBody();
    List<Customers> expected = buildExpected();
    
    actual.forEach(customers -> customers.setCustomerId((Integer) null));
    
    assertThat(actual).isEqualTo(expected);
    
     
  }



}
