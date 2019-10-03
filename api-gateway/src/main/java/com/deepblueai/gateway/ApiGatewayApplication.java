package com.deepblueai.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author purgeyao
 * @since 1.0
 */
@Slf4j
@EnableZuulProxy
@RestController
@SpringBootApplication(scanBasePackages = {"com.deepblueai.gateway"})
public class ApiGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiGatewayApplication.class, args);
  }

  @GetMapping("apiGateway")
  public String apiGateway() {
    return "apiGateway";
  }

}
