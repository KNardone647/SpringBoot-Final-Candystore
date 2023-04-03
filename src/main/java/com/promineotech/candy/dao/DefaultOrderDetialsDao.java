package com.promineotech.candy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.candy.entity.OrderDetails;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DefaultOrderDetialsDao implements OrderDetialsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate; 
  
  @Override
  public List<OrderDetails> fetchOrderDetials(int productId) {
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM orderdetials "
        + "WHERE product_id = :product_id ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("product_id", productId);
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
          @Override
          public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
          // @formatter:off
            return OrderDetails.builder()
                .orderId(rs.getInt("order_id"))
                .quantity(rs.getInt("quantity"))
                .paidEach(rs.getBigDecimal("paid_each"))
                .build();
            // @formatter:on
          }
      });
          
  }

}
