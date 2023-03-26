package com.promineotech.candy.entity;

import java.sql.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class OrderRequest {

  @NotNull
  @Length(max = 30)
  private String customers;
  
  

//  public static String getSize() {
//    // TODO Auto-generated method stub
//    return null;
//  } 
}
