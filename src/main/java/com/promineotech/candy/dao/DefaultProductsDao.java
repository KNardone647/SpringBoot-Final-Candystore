package com.promineotech.candy.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.candy.entity.Products;
import org.springframework.jdbc.core.RowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

@Component
@Slf4j
public class DefaultProductsDao implements ProductsDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  //connects to data base and sends to other layers, for our swagger connection
  

  @Override
  public List<Products> fetchProducts() {
    log.info("In products.dao.fetchProducts");
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM products ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<Products>() {
      
          @Override
          public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off 
            return Products.builder()
                .productId(rs.getInt("product_id"))
                .productName(rs.getString("product_name"))
                .cost(new BigDecimal(rs.getString("cost")))
                .inventory(rs.getInt("inventory"))
                .commonAllergiens(rs.getString("common_allergiens"))
                .ingredients(rs.getString("ingredients"))
                .brand(rs.getString("brand"))
                .typeProduct(rs.getString("type_product"))
                .build();
        // @formatter:on
            
            
          }});
  }

  public Products createProducts(String productName, BigDecimal cost, Integer inventory,
      String commonAllergiens, String ingredients, String brand, String typeProduct) {
    
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql = ""
        + "INSERT into products "
        + "(product_name, cost, inventory, common_allergiens, ingredients, brand, type_product) " 
        + "VALUES (:product_name, :cost, :inventory, :common_allergiens, :ingredients, :brand, :type_product)" ;
    sqlparams.source.addValue("product_name", productName);
    sqlparams.source.addValue("cost", cost);
    sqlparams.source.addValue("inventory", inventory);
    sqlparams.source.addValue("common_allergiens", commonAllergiens);
    sqlparams.source.addValue("ingredients",ingredients);
    sqlparams.source.addValue("brand",brand);
    sqlparams.source.addValue("type_product",typeProduct);
  

    

    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return Products.builder()
        .productId(keyHolder.getKey().intValue())
        .productName(productName)
        .cost(cost)
        .inventory(inventory)
        .commonAllergiens(commonAllergiens)
        .ingredients(ingredients)
        .brand(brand)
        .typeProduct(typeProduct)
        .build();
  }
      class SqlParams {
      String sql;
      MapSqlParameterSource source = new MapSqlParameterSource();
  }
     
      //put operation passing to database
      
      @Override
      public Products updateProducts(int productId, String productName, BigDecimal cost, Integer inventory,
          String commonAllergiens, String ingredients, String brand, String typeProduct) {
       
      //@formatter:off
        String sql = ""
            + "UPDATE products "
            + "SET " 
            + "product_name = :product_name, "
            + "cost = :cost, "
            + "inventory = :inventory, "
            + "common_allergiens = :common_allergiens, "
            + "ingredients = :ingredients, "
            + "brand = :brand, "
            + "type_product = :type_product "
            + "WHERE product_id = :product_id;";
        //@formatter:on
        

        Map<String, Object> params = new HashMap<>();
        params.put("product_name", productName);
        params.put("cost", cost);
        params.put("inventory", inventory);
        params.put("common_allergiens", commonAllergiens);
        params.put("ingredients", ingredients);
        params.put("brand", brand);
        params.put("type_product", typeProduct);
        params.put("product_id", productId);

        jdbcTemplate.update(sql, params);
        //formatter:off
        return Products.builder()
            .productId(productId)
            .productName(productName)
            .cost(cost)
            .inventory(inventory)
            .commonAllergiens(commonAllergiens)
            .ingredients(ingredients)
            .brand(brand)
            .typeProduct(typeProduct)
            .build();
        //formatter:on
      }

      @Override
      public void deleteProducts(int productId) {
       
      //@formatter:off
        String sql = ""
            + "DELETE FROM products "
            + "WHERE product_id = :product_id;";
        //@formatter:on

       Map<String, Object> params = new HashMap<>();
       params.put("product_id", productId);

       jdbcTemplate.update(sql, params); // returns number of rows affected
       return;
        
      }

  
}
