package com.promineotech.candy.controller;

import java.util.List;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.candy.Constants;
import com.promineotech.candy.entity.Customers;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;


@Validated
@RequestMapping("/customers")
@OpenAPIDefinition(info = @Info(title = "Customers"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface CustomersController {
 
  

  //@formatter:off
  @Operation(
      summary = "Returns customer",
      description = "Returns a customer given first and last name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of customers is returned", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
               content = @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode = "404",
              description = "No customers were found with input criteria",
              content = @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
           content = @Content(mediaType = "application/json"))
          
      },
      parameters = {
          @Parameter(
              name = "firstName",
              allowEmptyValue = false, 
              required = false, 
              description = "The customer's first name, ie like Melissa"),
          
          @Parameter(
              name = "lastName",
              allowEmptyValue = false,
              required = false,
              description = "The customer's last name, ie like Jones")
          
          }
      
      )
  
 

  
  //** note I labeled this wrong this should have been fetch one customer method
  //** not fetchCustomers method 
  @GetMapping("/aCustomer")
  @ResponseStatus(code = HttpStatus.OK)
  List<Customers> fetchCustomers(
      @RequestParam(required = false)
      String firstName,
      @Length(max = Constants.NAME_MAX_LENGTH_50)
      @RequestParam(required = false)
      String lastName);

//@formatter:on
}

