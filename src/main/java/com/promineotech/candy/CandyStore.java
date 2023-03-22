package com.promineotech.candy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class CandyStore {

  public static void main(String[] args) {
    
    //running spring application and loading classes
SpringApplication.run(CandyStore.class, args);
  }

}
