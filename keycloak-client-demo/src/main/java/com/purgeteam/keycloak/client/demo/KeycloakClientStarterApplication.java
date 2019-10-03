package com.purgeteam.keycloak.client.demo;

import io.purge.starter.dispose.annotation.EnableGlobalDispose;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableGlobalDispose
@SpringBootApplication
public class KeycloakClientStarterApplication {

  public static void main(String[] args) {
    SpringApplication.run(KeycloakClientStarterApplication.class, args);
  }

}
