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
import com.promineotech.candy.entity.OrderDetails;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;


@Validated
@RequestMapping("/orderdetials")
@OpenAPIDefinition(info = @Info(title = "Order Detials"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface OrderDetialsController {
 
  

  //@formatter:off
  @Operation(
      summary = "Returns order detials",
      description = "Returns the order detials given the product Id ",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of order details is returned", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = OrderDetails.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
               content = @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode = "404",
              description = "No order detials were found with input criteria",
              content = @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
           content = @Content(mediaType = "application/json"))
          
      },
          parameters = {
              @Parameter(name = "productId",
                  allowEmptyValue = false,
                  required = false,
                  description = "The product Id for the order")
            }
      
      )
  
 

  
  //** note I labeled this wrong this should have been fetch one customer method
  //** not fetchCustomers method 
  @GetMapping("/An order")
  @ResponseStatus(code = HttpStatus.OK)
  List<OrderDetails> fetchOrderDetials(
      @RequestParam(required = false)
      int productId); 

//@formatter:on
}

