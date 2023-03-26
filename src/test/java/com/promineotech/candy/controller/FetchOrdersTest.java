package com.promineotech.candy.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.candy.controller.support.FetchOrdersTestSupport;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
  scripts = {"classpath:flyway/migrations/CandyStore1.sql", 
             "classpath:flyway/migrations/CandyStoreData.sql"}, 
      config = @SqlConfig(encoding = "utf-8"))
class FetchOrdersTest extends FetchOrdersTestSupport {

  @Test
  void test() {
    System.out.println(getBaseUriForOrders());
  }

}
