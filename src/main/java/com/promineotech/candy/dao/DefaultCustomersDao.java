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
import com.promineotech.candy.entity.Customers;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCustomersDao implements CustomersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate; 
  
  
  @Override
  public List<Customers> fetchCustomers(String firstName, String lastName) {
    log.debug("Dao: firstName{}, lastName{}", firstName, lastName);
    
    //formatter: on
    String sql = ""
         + "SELECT * "
         + "FROM customers "
         + "WHERE first_name = :first_name AND last_name = :last_name";
    //formatter: off 
    
  
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", firstName);
    params.put("last_name", lastName);
         
         
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      @Override
      public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
     // @formatter:off
        return Customers.builder()
            .customerId(rs.getInt("customer_id"))
            .firstName(rs.getString("first_name"))
            .lastName(rs.getString("last_name"))
            .phone(rs.getString("phone"))
            .build();
     // @formatter:on
      }});
  }

}
