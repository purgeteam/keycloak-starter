package com.deepblueai.gateway.config.security;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author purgeyao
 * @since 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "zuul.permissions")
public class SecurityProperties {

  private Set<String> filterUrls = new HashSet<>();

  private Boolean isZuulPathFilter = false;

}
