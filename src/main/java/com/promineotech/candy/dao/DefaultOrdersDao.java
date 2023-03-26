package com.promineotech.candy.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.candy.dao.DefaultProductsDao.SqlParams;
//import com.promineotech.candy.entity.Customers;
//import com.promineotech.candy.entity.OrderRequest;
import com.promineotech.candy.entity.Orders;
//import com.promineotech.candy.entity.Products;
import lombok.extern.slf4j.Slf4j;

@Component
public class DefaultOrdersDao implements OrdersDao {
  
  
//  private int orderId; 
//  
//  private int customerId;
//  
//  private String size; 
// 
//  private Timestamp orderDate;
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Orders> fetchOrders() {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM orders ";
    // @formatter:on
    
 Map<String, Object> params = new HashMap<>();
    
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<Orders>() {
      
          @Override
          public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off 
            return Orders.builder()
                .orderId(rs.getInt("order_id"))
                .customerId(rs.getInt("customer_id"))
                .size(rs.getString("size"))
                .orderDate(rs.getTimestamp("order_date"))
                .build() ;
            
            // @formatter:on
            
            
          }});
    
  
  } 
  
//  commented out the whole orders create line 
//  static Orders saveOrder(Customers customers) {
//    // TODO Auto-generated method stub
//    SqlParams params = 
//        generateInsertSql(customers);
//    
//   KeyHolder keyholder = new GeneratedKeyHolder();
//   jdbcTemplate.update(params.sql, params.source, keyHolder);
//   
//   Long orderId = keyHolder.getKey().longValue();
//   saveOptions(options, orderId);
//   }
////  
//  
//  private static SqlParams generateInsertSql(Customers customers) {
//    //formatter:off
//    String sql = ""
//      + "INSERT INTO orders ("
//      + "customer_id, size, order_date"
//      +") VALUES ("
//      +":customer_id, :size, :order_date"
//      +")";
//    //formatter: on
//    
//    SqlParams params = new SqlParams();
//    
//    params.sql= sql;
//    params.source.addValue("customer_id", customers.getcustomerId());
////    params.source.addValue("size", orders.getSize());
////    params.source.addValue("order_date", orders.getDate());
//        
//    return null;
//  }

//  @Override
//  public Optional<Customers> fetchCustomers(String customerId) {
//        String sql = ""
//        + "SELECT * "
//        + "FROM customers "
//        + "WHERE customer_id = :customer_id";
//        
//        
//        Map<String, Object> params = new HashMap<>();
//        params.put("customer_id", customerId);
//        
//    return Optional.ofNullable(jdbcTemplate.query(sql, params, new CustomersResultSetExtractor()));
//  }
//
// class CustomersResultSetExtractor implements ResultSetExtractor<Customers>{
//
//     @Override
//     public Customers extractData(ResultSet rs)
//         throws SQLException, DataAccessException {
//      rs.next();
//      
//      //@formatter:off
//      return Customers.builder()
//          .customerId(rs.getLong("customer_id"))
//          .firstName(rs.getString("first_name"))
//          .lastName(rs.getString("last_name"))
//          .phone(rs.getString("phone"))
//          .build();  
//       //formatter:on
//     }
// }
//  class sqlParams {
//    String sql;
//    MapSqlParameterSource source = new MapSqlParameterSource();
//    
//  }
 
 
}
