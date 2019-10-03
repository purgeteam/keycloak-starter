package com.deepblueai.gateway.config.security;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author purgeyao
 * @since 1.0
 */
@Slf4j
@Configuration
@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Resource
  private SecurityProperties properties;

  @Resource
  private ZuulProperties zuulProperties;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    // 禁用CSRF防护功能
    // 这里之所以要禁用csrf，是为了方便。
    // 否则，退出链接必须要发送一个post请求，请求还得带csrf token
    // 那样还得写一个界面，发送post请求
    http.csrf().disable();
    // 所有请求都得经过认证和授权
    http.antMatcher("/**").authorizeRequests().anyRequest().authenticated();
    log.info("[SecurityConfiguration] Load the success");
  }

  /**
   * 设置权限过滤(允许访问)
   */
  @Override
  @SuppressWarnings("all")
  public void configure(WebSecurity web) throws Exception {
    // get filter urls
    Set<String> filterUrlList = properties.getFilterUrls();
    if (properties.getIsZuulPathFilter()) {
      // get zuul all service path list
      List<String> zuulPathList = zuulProperties.getRoutes().values()
          .stream().map(ZuulRoute::getPath).collect(Collectors.toList());
      filterUrlList.addAll(zuulPathList);
    }
    String[] filterUrls = filterUrlList.toArray(new String[filterUrlList.size()]);
    // 允许所有用户访问
    web.ignoring().antMatchers(filterUrls);
  }

}
