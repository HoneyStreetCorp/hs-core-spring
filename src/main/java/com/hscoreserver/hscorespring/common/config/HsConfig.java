package com.hscoreserver.hscorespring.common.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class HsConfig {

  @Value("{hscore.base-url}")
  private String baseUrl;

}
