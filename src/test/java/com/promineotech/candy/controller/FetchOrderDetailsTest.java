package com.promineotech.candy.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.promineotech.candy.controller.support.FetchOrderDetailsSupport;

class FetchOrderDetailsTest extends FetchOrderDetailsSupport {

  @Test
  void test() {
    System.out.println(getBaseUriForOrderDetials());
  }

}
