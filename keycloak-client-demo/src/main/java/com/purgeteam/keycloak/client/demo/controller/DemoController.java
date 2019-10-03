package com.purgeteam.keycloak.client.demo.controller;

import io.purge.starter.dispose.annotation.IgnorReponseAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author purgeyao
 * @since 1.0
 */
@RestController
public class DemoController {

  @GetMapping("test")
  public String test(){
    return "test";
  }

  @IgnorReponseAdvice
  @GetMapping("test1")
  public String test1(){
    return "test1";
  }


  @GetMapping("testError")
  public void testError() throws Exception {
    throw new Exception("模拟异常");
  }

}
