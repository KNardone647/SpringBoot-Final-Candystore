package com.promineotech.candy.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
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
//import com.promineotech.jeep.Constants;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
  scripts = {"classpath:flyway/migrations/CandyStore1.sql", 
             "classpath:flyway/migrations/CandyStoreData.sql"}, 
      config = @SqlConfig(encoding = "utf-8"))
class FetchCustomersTest extends FetchCustomersTestSupport{
 
 //if this continues not to work can comment out this test 
  @Test
void testThatCustomerIsReturnedWhenValidFirstandLastNameSupplied() {
   //Given: a valid firstName and lastName
     String firstName = "Melissa";
     String lastName = "Jones";
     
     String uri =String.format("%s?firstName=%s&lastName=%s", getBaseUriForCustomers(), firstName, lastName);
     
     
    
     
    //When: a connection is made to the URI
     //this expects list of customers back 
     //error is line 55 to 59 
     ResponseEntity<List<Customers>> response =
         getRestTemplate().exchange(uri,HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    
    //Then: a success (OK - 200) Status Code is returned 
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //And: the actual list is the same as the expected list 
    List<Customers> actual = response.getBody();
    List<Customers> expected = buildExpected();
    
//    actual.forEach(customers -> customers.setCustomerId((Integer) null));
    
    assertThat(actual).isEqualTo(expected);
    
 
     
  }
  
  @Test
void testThatAnErrorMessageisReturnedWhenAnUnknownfirstNameisSupplied() {
   //Given: a valid firstName and lastName
     String firstName = "Unknown value";
     String lastName = "Jones";
     
     String uri =String.format("%s?firstName=%s&lastName=%s", getBaseUriForCustomers(), firstName, lastName);
     
    
    //When: a connection is made to the URI
     //this expects list of customers back 
     
     ResponseEntity<Map<String, Object>> response =
         getRestTemplate().exchange(uri,HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    
    //Then: a success (OK - 404) Status Code is returned 
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    
    //And: and error message is returned 

    Map<String, Object> error = response.getBody();
    
    assertErrorMessageValid(error, HttpStatus.NOT_FOUND);
  }
  
  @ParameterizedTest
  @MethodSource("com.promineotech.candy.controller.FetchCustomersTest#ParametersForInvalidInput")
void testThatAnErrorMessageisReturnedWhenAnInValidfirstNameisSupplied(
    String firstName, String lastName, String reason) {
   //Given: a valid firstName and lastName
     
     
     String uri =String.format("%s?firstName=%s&lastName=%s", getBaseUriForCustomers(), firstName, lastName);
     
    
    //When: a connection is made to the URI
     //this expects list of customers back 
     
     ResponseEntity<Map<String, Object>> response =
         getRestTemplate().exchange(uri,HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    
    //Then: a not found (OK - 400) Status Code is returned 
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    
    //And: and error message is returned 

    Map<String, Object> error = response.getBody();
    
    assertErrorMessageValid(error, HttpStatus.BAD_REQUEST);
  }


  static Stream<Arguments> ParametersForInvalidInput() {
    //@formatter:off
   return Stream.of(
       arguments("MELISSA", "C".repeat(com.promineotech.candy.Constants.NAME_MAX_LENGTH_50 + 1), "Lastname length too long")
    //@formatter:on
       ); }
  

}
