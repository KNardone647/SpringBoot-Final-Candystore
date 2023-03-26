package com.promineotech.candy.controller;

import java.util.List;
import javax.validation.Valid;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.candy.Constants;
import com.promineotech.candy.entity.Customers;
import com.promineotech.candy.entity.OrderRequest;
import com.promineotech.candy.entity.Orders;
import com.promineotech.candy.entity.Products;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;


@Validated
@RequestMapping("/orders")
@OpenAPIDefinition(info = @Info(title = "Order Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface OrdersController {
 
  
//formatter:off  
  @Operation(
      summary = "Returns the list of Orders",
      description = "Returns a list of Orders",
          responses = {
              @ApiResponse(
                  responseCode = "200",
                  description = "A list of Orders gets returned",
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Orders.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameters are invalid",  
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No Orders were found",  
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occurred.",  
                  content = @Content(mediaType = "application/json")),
          }
     )
  
  
          
  @GetMapping("/all")
  @ResponseStatus(code = HttpStatus.OK)
  List<Orders> fetchOrders();
  

  //commenting out create orders 
//  //@formatter:off
//  @Operation(
//      summary = "Create an order for a customer",
//      description = "Returns the customer's order ",
//      responses = {
//          @ApiResponse(
//              responseCode = "201",
//              description = "The created order is returned", 
//              content = @Content(mediaType = "application/json", 
//              schema = @Schema(implementation = Orders.class))),
//          @ApiResponse(
//              responseCode = "400",
//              description = "The request parameters are invalid",
//               content = @Content(mediaType = "application/json")), 
//          @ApiResponse(
//              responseCode = "404",
//              description = "An order component was not found with input criteria",
//              content = @Content(mediaType = "application/json")), 
//          @ApiResponse(
//              responseCode = "500",
//              description = "An unplanned error occurred",
//           content = @Content(mediaType = "application/json"))
//          
//      },
//      parameters = {
//          @Parameter(
//              name = "orderRequest",
//              allowEmptyValue = true, 
//              description = "The order as JSON")
//          
//          }
//      
//      )
//  
// 
//
// 
//  @PostMapping
//  @ResponseStatus(code = HttpStatus.CREATED)
//  Orders createOrder(@Valid @RequestBody OrderRequest orderRequest);

//@formatter:on
}

