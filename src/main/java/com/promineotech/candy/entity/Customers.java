package com.promineotech.candy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Comparator; 

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customers  {

// do I need to change to long? 
  private Long customerId;
  
  private String firstName;
  
  private String lastName;
  
  private String phone;
  
  @JsonIgnore
  public Long getcustomerId() {
    return customerId; 
  }

  //tried to implement this but it did not work 
//  @Override
//  public int compareTo(Customers that) {
//    //@formatter: off 
//    return Comparator
//        .comparing(Customers::getfirstName)
//        .thenComparing(Customers::getlastName)
//        .compare(this, that);
//    //@formatter: on 
  }

