package com.promineotech.candy.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.candy.controller.model.ProductsDTO;
import com.promineotech.candy.entity.Products;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

@RequestMapping("/products")
@OpenAPIDefinition(info = @Info(title = "Products Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface ProductsController {
   //formatter:off  
  @Operation(
      summary = "Returns the list of Products",
      description = "Returns a list of Products",
          responses = {
              @ApiResponse(
                  responseCode = "200",
                  description = "A list of Products gets returned",
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Products.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameters are invalid",  
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No Products were found",  
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occurred.",  
                  content = @Content(mediaType = "application/json")),
          }
     )
  
  
          
  @GetMapping("/all")
  @ResponseStatus(code = HttpStatus.OK)
  List<Products> fetchProducts();
  
  //formatter:on
//  
//  //formatter:off  
// @Operation(
//     summary = "Returns the list of Products",
//     description = "Returns a list of Products",
//         responses = {
//             @ApiResponse(
//                 responseCode = "200",
//                 description = "A list of Products gets returned",
//                 content = @Content(
//                     mediaType = "application/json", 
//                     schema = @Schema(implementation = Products.class))),
//             @ApiResponse(
//                 responseCode = "400", 
//                 description = "The request parameters are invalid",  
//                 content = @Content(mediaType = "application/json")),
//             @ApiResponse(
//                 responseCode = "404", 
//                 description = "No Products were found",  
//                 content = @Content(mediaType = "application/json")),
//             @ApiResponse(
//                 responseCode = "500", 
//                 description = "An unplanned error occurred.",  
//                 content = @Content(mediaType = "application/json")),
//         },
//         parameters = {
//             @Parameter(name = "productName", 
//              allowEmptyValue = false, 
//              required = false, 
//              description = "The product name ie. Ice Cream"),
//             @Parameter(name = "cost", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "The cost of the product"),
//             @Parameter(name = "inventory", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "The count of products in inventory"),
//             @Parameter(name = "commonAllergiens", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "Any common allergiens in product like nuts"),
//             @Parameter(name = "ingredients", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "The full list of ingredients"),
//             @Parameter(name = "brand", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "the brand ex Coca Cola "),
//             @Parameter(name = "typeProduct", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "the type of product ex is it Candy or Soda "),
//         }
//    )
// 
// 
//         
// @PostMapping
// @ResponseStatus(code = HttpStatus.CREATED)
// Products createProducts(String productName,
//     BigDecimal cost, Integer inventory, String commonAllergiens, String ingredients,
//     String brand, String typeProduct);
//    
// //formatter:on
//  
//}
  
  //formatter:off  
 @Operation(
     summary = "Create a new product",
     description = "Create a new product",
         responses = {
             @ApiResponse(
                 responseCode = "200",
                 description = "A product was created",
                 content = @Content(
                     mediaType = "application/json", 
                     schema = @Schema(implementation = Products.class))),
             @ApiResponse(
                 responseCode = "400", 
                 description = "The request parameters are invalid",  
                 content = @Content(mediaType = "application/json")),
             @ApiResponse(
                 responseCode = "404", 
                 description = "No Products were found",  
                 content = @Content(mediaType = "application/json")),
             @ApiResponse(
                 responseCode = "500", 
                 description = "An unplanned error occurred.",  
                 content = @Content(mediaType = "application/json")),
         }
//         parameters = {
//             @Parameter(name = "productName", 
//              allowEmptyValue = false, 
//              required = false, 
//              description = "The product name ie. Ice Cream"),
//             @Parameter(name = "cost", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "The cost of the product"),
//             @Parameter(name = "inventory", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "The count of products in inventory"),
//             @Parameter(name = "commonAllergiens", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "Any common allergiens in product like nuts"),
//             @Parameter(name = "ingredients", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "The full list of ingredients"),
//             @Parameter(name = "brand", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "the brand ex Coca Cola "),
//             @Parameter(name = "typeProduct", 
//             allowEmptyValue = false, 
//             required = false, 
//             description = "the type of product ex is it Candy or Soda "),
//         }
    )
 
 
         
 @PostMapping
 @ResponseStatus(code = HttpStatus.CREATED)
 Products createProducts(@Valid @RequestBody ProductsDTO productsDTO );
    
 //formatter:on
  
//Update an existing client
 
 @Operation(
     summary = "Updates a product",
     description = "Returns updated product",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "A product was updated!", 
             content = @Content(
                 mediaType = "application/json", 
             schema = @Schema(implementation = Products.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid.", 
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "Unable to update the product with the input criteria.", 
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred.", 
             content = @Content(
                 mediaType = "application/json"))
     }
 )
 
 //Put method (update)

 @PutMapping
 @ResponseStatus(code = HttpStatus.OK)
 Products updateProducts(@Valid @RequestBody ProductsDTO productsDTO); 
 // @formatter:on
 
 @Operation(
     summary = "deletes a product",
     description = "delete a product",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "A product was deleted!", 
             content = @Content(
                 mediaType = "application/json", 
             schema = @Schema(implementation = Products.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid.", 
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "Unable to update the product with the input criteria.", 
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred.", 
             content = @Content(
                 mediaType = "application/json"))
     }
 )
 
 //Put method (update)

 @DeleteMapping
 @ResponseStatus(code = HttpStatus.OK)
 void deleteProducts(@Valid @RequestBody ProductsDTO productsDTO); 
 // @formatter:on
}
